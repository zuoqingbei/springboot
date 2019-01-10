$(function () {
    // 通过登录信息判断模块权限
    console.log(userInfo.dim_access);
    userInfo.dim_access.forEach((item, i) => {
        $('.nav_btns .pt_btn').eq(item).css('display','block');
    })

    $('.nav_btns .pt_btn').each(function (i, item) {
        var url = '';
        switch (i) {
            case 0: url = '/bigSreen/sys/v1/sy-yhxw'; break;
            case 1: url = '/bigSreen/sys/v1/yhxv'; break;
            case 2: url = '/bigSreen/sys/v1/cdwl-sq'; break;
            case 3: url = '/bigSreen/sys/v1/fhxv'; break;
            default: url = '#';
        }
        $(item).click(function () {
            location.href = url;
        })
    })
})