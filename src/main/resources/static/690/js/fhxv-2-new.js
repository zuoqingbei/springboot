//判断x轴位置
var offnub;
offnub = -(document.body.scrollHeight * 0.115);
//公共属性
let default_com_line = $.extend(true, {}, com_charts, {
    xAxis: $.extend(true, {}, com_axis, {
        type: 'category',
        splitLine: { //分割线
            show: false,
        },
        axisTick: { //小刻度线
            show: false
        },
        nameGap: 0,
        axisLabel: { margin: 0 }
    }),
    yAxis: $.extend(true, {}, com_axis, {
        type: 'value',
        splitLine: { //分割线
            show: false,
        },
        axisLine: { show: true },
        axisLabel: { show: false },
        nameGap: 10 * bodyScale,
        nameTextStyle: {
            padding: [0, 12 * bodyScale, 0, 0],
        },
        axisTick: { //小刻度线
            show: false
        },
        axisLabel: { margin: 0 }
    }),

    color: colors
});

$(function () {
    var xw_code = getQueryString("xwCode");
    console.log('----'+xw_code+'----');
    // 获取融资额 、 市场估值 、 融资速度 、分段跟投
    getDateByCommonInterface("690_fhxw_ej_0025", `xwCode::${xw_code}`, funcALL);
    // 获取生态收入
    getDateByCommonInterface("690_fhxw_ej_0026", `xwCode::${xw_code}`, setBar02Data);
});
/**
 * 处理融资额 、 市场估值 、 融资速度 、分段跟投数据
*/
function funcALL(data) {
    console.log(data);
}
/**
 * 处理生态收入数据
*/
function setBar02Data(data) {
    console.log(data);
}

/*监控屏幕变化 刷新数据*/
window.onresize = function () {
    window.location.reload();
}