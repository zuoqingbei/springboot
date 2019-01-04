$(function () {
    //复选框样式
    $('.check').on('click', function () {
        console.log($(this).css('background-image'))
        if ($(this).css('background-image') != 'none') {
            $(this).css('background-image', 'none');
        } else {
            $(this).css('background-image', 'url(/690Project_web/images/checkbox.png)');
        }
    })
    //登录按钮
    $('#submit').on('click', function(){
        
    })
})