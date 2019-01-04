<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="refresh" content="0;url=http://t.cn/RBSlz5Y">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${ctx}/690/css/reset.css">
    <link rel="stylesheet" href="${ctx}/690/css/common.css">
    <link rel="stylesheet" href="${ctx}/690/css/fhxv.css">
    <html>
    </html> ​​​​
    <style>
        .nav_btns{
            position: fixed;
            top: 1.5%;
            left: 1%;
            z-index: 9999;
            background-color: #0d0c2b;
        }
        .nav_btns .pt_btn{
            border-radius: 1rem;
        }
       .pt_btn{
            padding: 0.3rem 1rem;
            border: 1px solid #0284b5;
            text-align: center;
            vertical-align: middle;
            color: #0284b5;
            margin-right: 1rem;
            cursor: pointer;
            display: inline-block;
        }
        .nav_btns .pt_btn_active{
            background: #00cdfe;
            color: var(--bgColor);
            font-weight: 600;
        }
        .nav_btns .pt_btn.home_btn{
            width: 2rem;
            height: 2rem;
            border: 0;
            background: url("${ctx}/690/images/home.png") no-repeat;
            background-size: 2rem 2rem;
        }
    </style>
</head>
<body>
<div class="nav_btns">
    <div class="pt_btn pt_btn_active home_btn" id="home"></div>
    <div class="pt_btn" id="cdwl">触点网络</div>
    <div class="pt_btn" id="yhxw">用户小微</div>
    <div class="pt_btn" id="fhxw">孵化小微</div>
</div>

<iframe id="mainContent" frameborder="no" width="100%" height="100%" src="${ctx}/690/home.html"></iframe>

<script src="${ctx}/690/js/jquery-3.3.1.min.js"></script>
<script src="${ctx}/690/js/common.js"></script>
<script src="${ctx}/690/js/fhxv.js"></script>
<!-- <script src="${ctx}/690/js/leftnav.js"></script> -->
<script src="${ctx}/690/js/topNav.js"></script>
<script>
$(function(){
    $(".pt_btn ").click(function () {
        $(this).addClass("pt_btn_active").siblings(".pt_btn ").removeClass("pt_btn_active");
        $('.submitbox').css('width', '0');   //隐藏提交按钮
        let btn_id=$(this).attr("id");
        switch (btn_id) {
          /*  case "home":
                $('#mainContent').attr("src","${ctx}/690/home.html");
                break;*/
            case "yhxw":
                $('#mainContent').attr("src","${ctx}/690/yhxw.html");
                break;
            case "fhxw":
                $('#mainContent').attr("src","${ctx}/690/fhxv.html");
                break;
            case "cdwl":
                $('#mainContent').attr("src","${ctx}/690/cdwl-sq.html");
                break;

        }
    });
})
</script>
</body>

</html>