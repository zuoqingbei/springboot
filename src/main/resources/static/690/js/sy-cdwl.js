$(function(){
    getDateByCommonInterface('690_cdwl_004', 'inCode::001;;time::20181126;;sqCode::ALL', sycdwl);
    function sycdwl(data){
        abledata = data['690_cdwl_s004'];
        console.log(abledata);
        var arr = grouping(abledata);
        var tables = document.querySelectorAll('.tables');
        for (let j = 1; j <= tables.length; j++) {
            $('.lunci'+j+' .block_scroll').each(function (i, item) {
                $(item).html(creatDiv(arr[i]));
            });
        }
    }

    
    // 通用函数----节点渲染

    // 定义变量
    var str;

    // 执行与判断
    // 1.数据按纵轴指标分组
    function grouping(data) {
        var arr = [[], [], [], [], []];
        data.forEach(function (item, i) {
            switch (item['YZZB']) {
                case '终身触点': arr[0].push(item); break;
                case '触点三级': arr[1].push(item); break;
                case '触点二级': arr[2].push(item); break;
                case '触点一级': arr[3].push(item); break;
                case '触点': arr[4].push(item); break;
            }
        });
        return arr;
    }
    // 2.生成对应标签
    function creatDiv(arr) {
        str = '';
        if (!arr) {
            return str;
        }
        if (arr.length == 1) {
            str = '<div class="block_scroll_screen_off">';
            arr.forEach(creatStr);
            str += '</div>';
        } else if (arr.length > 1) {
            str = '<div class="block_scroll_screen">';
            arr.forEach(creatStr);
            str += '</div>';
        }
        return str;
    }
    // 3.拼接字符串
    function creatStr(item, i) {
        str +=
            `<div class="roll">
                <div class="pointer">
                    <div class="p_on `+ xJudge(item) + `" >
                        <span class=`+ starColor(item) + `></span>
                    </div>
                    <div>
                        <div class="p_on_tit">` + item['SQ_NAME'] + `(` + item['SQZ'] + `)<span class="` + rise(item) + `"></span></div>
                    </div>
                </div>
            </div>`;
    }
    // 4.判断纵轴指标定义点的位置
    function xJudge(item) {
        var xclass;
        switch (item['XZZB']) {
            case '行业增长': xclass = ''; break;
            case '达不成': xclass = 'p_on_2'; break;
            case '达成': xclass = 'p_on_3'; break;
            case '达成1.2倍': xclass = 'p_on_4'; break;
            case '绝对引领': xclass = 'p_on_5'; break;
        }
        return xclass;
    }
    // 5.判断星级定义点的颜色
    function starColor(item) {
        var starlv = '';
        switch (item['XJ']) {
            case '1': starlv = 'one'; break;
            case '2': starlv = 'two'; break;
            case '3': starlv = 'three'; break;
            case '4': starlv = 'four'; break;
            case '5': starlv = 'five'; break;
        }
        return starlv;
    }
    // 6.判断增幅趋势图表
    function rise(item) {
        var zf = '';
        switch (item['XJ_ZF']) {
            case '1': zf = 'sheng'; break;
            case '0': zf = 'ping'; break;
            case '-1': zf = 'jiang'; break;
            default: zf = '';
        }
        return zf;
    }
})