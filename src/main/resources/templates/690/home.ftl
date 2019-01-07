<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${ctx}/690/css/reset.css">
    <link rel="stylesheet" href="${ctx}/690/css/common.css">
    <link rel="stylesheet" href="${ctx}/690/css/fhxv.css">
    <link rel="icon" type="image/x-icon" href="favicon.ico" />
    <title>小微分类升级驱动体系</title>
    <style>
        .btns{
            position: absolute;
            top: 7%;
            right: -25%;
            background-color: #0d0c2b;
            height: 5.2%;
            width: 57%;
            padding-left: 20%;
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
        .pt_btn_active{
            border: 1px solid #00cdfe;
            color: #00cdfe;
            font-weight: 600;
        }

        .nav_btns{
            position: fixed;
            top: 1.5%;
            left: 1%;
            z-index: 9999;
            background-color: #0d0c2b;
        }
        .nav_btns .pt_btn{
            padding: 0.3rem 1rem;
            border: 1px solid #0284b5;
            text-align: center;
            vertical-align: middle;
            color: #0284b5;
            margin-right: 1rem;
            cursor: pointer;
            display: inline-block;
            border-radius: 1rem;
        }
        .nav_btns .pt_btn_active{
            color: #00cdfe;
            font-weight: 600;
            border: 1px solid #00cdfe;
        }
        .nav_btns .pt_btn.home_btn{
            width: 2rem;
            height: 2rem;
            border: 0;
            background: url("${ctx}/690/images/home.png") no-repeat;
            background-size: 2rem 2rem;
        }
        @media (max-width: 1400px) {
            .btns {
                right: -23.5%;
            }
        }
        @media screen and (min-height: 801px) and (min-width: 1400px){
            .btns{
                height: 4.1%;
            }
        }
    </style>
</head>
<body>

<div class="nav_btns">
    <div class="pt_btn home_btn" id="home"></div>
    <div class="pt_btn" id="yhxw">用户小微</div>
    <div class="pt_btn" id="cdwl">触点网络</div>
    <div class="pt_btn" id="fhxw">孵化小微</div>
</div>
<!-- <div class="btns">
        <div class="pt_btn pt_btn_active" id="yhxw">用户小微</div>
        <div class="pt_btn" id="cdwl">触点网络</div>
        <div class="pt_btn" id="fhxw">孵化小微</div>
</div> -->
<iframe id="mainContent" frameborder="no" width="100%" height="100%" src="${ctx}/bigSreen/sys/v1/sy-yhxw"></iframe>
<!-- <div class="leftnav">
    <div class="show_btn">
        <img src="${ctx}/690/images/侧栏icon.png" alt="">
    </div>
    <div class="logo flex_center">Haier</div>
    <div class="menu_item flex_center">首页</div>
    <div class="menu_item flex_center hav_sec">触点网络</div>
    <div class="menu_item menu_item_in">
        <div class="menu_item menu_item_sec flex_center">触点网络-商圈</div>
        <div class="menu_item menu_item_sec flex_center">触点网络-网格</div>
    </div>
    <div class="menu_item flex_center">用户小微</div>
    <div class="menu_item flex_center">孵化小微</div> -->
</div>
<script src="${ctx}/690/js/jquery-3.3.1.min.js"></script>
<script src="${ctx}/690/js/common.js"></script>
<script src="${ctx}/690/js/fhxv.js"></script>
<!-- <script src="${ctx}/690/js/leftnav.js"></script> -->
<script src="${ctx}/690/js/topNav.js"></script>
</body>
<script>
    $(function(){
        /* 平台切换*/
        $(".pt_btn ").click(function () {
            $(this).addClass("pt_btn_active").siblings(".pt_btn ").removeClass("pt_btn_active");
            $('.submitbox').css('width', '0');   //隐藏提交按钮
            let btn_id=$(this).attr("id");
            switch (btn_id) {
                case "yhxw":
                    $('#mainContent').attr("src","${ctx}/bigSreen/sys/v1/sy-yhxw");
                    break;
                case "fhxw":
                    $('#mainContent').attr("src","${ctx}/bigSreen/sys/v1/fhxv");
                    break;
                case "cdwl":
                    $('#mainContent').attr("src","${ctx}/bigSreen/sys/v1/sy-cdwl");
                    break;

            }
        });
        


  /*      module="孵化";
        page_num=1;
        //绑定提交事件
        $("#submit").on("click",submitComment);
        $("#dateIpt").val(formatDate(new Date()));
        $("#reset").on("click",editDom);
        $("#select").on("click",searchFunction);
        //绑定融资轮次悬浮事件
        hoverFunForRzlcBlock();
    })
    $(function(){
        getDateByCommonInterface("hl_690_dp_industryinfo","",setIndustryInfo);
        searchFunction();
        */
    });

</script>
</html>