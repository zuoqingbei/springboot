<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${ctx}/690/css/reset.css">
    <link rel="stylesheet" href="${ctx}/690/css/common.css">
    <link rel="stylesheet" href="${ctx}/690/css/consumer_micro.css">
    <link rel="stylesheet" href="${ctx}/690/css/cdwl-sq-2.css">
    <link rel="icon" type="image/x-icon" href="${ctx}/690/images/favicon.ico" />
    <script>
        	let ctx = '${ctx}';
        </script>
    <title>小微分类升级驱动体系</title>
</head>
<body>

<div class="btn_grounp">
    <div class="pt_btn" id="back_btn">返回</div>
</div>

<div class="container">
    <nav>
        <div class="nav_top">
            <h2 class="title">网格纵横匹配显差</h2>
            <div class="time"><span></span>-<span></span>-<span></span>&nbsp;&nbsp;<span></span>:<span></span>:<span></span></div>
        </div>
    </nav>
    <div class="star_comment">
        <div class="micro_info">
            <span>产业：</span><span id="cyName"></span><span class="micro_name">网格：</span><span id="wgName"></span><span class="micro_name">产业网格主：</span><span id="WGZ"></span>
        </div>
    </div>
    <div class="main_content ">
        <div class="content_title">
            <!-- <div>纵横匹配显差</div> -->
        </div>
        <div class="title_name x_title">横轴：市场竞争力</div>
        <div class="axis_content x_content wg_content">
            <div id="ec01_line" style="width: 100%;height: 100%"></div>
            <div id="ec02_line" style="width: 100%;height: 100%"></div>
            <span class="arrow_box wg_lsze_arrow" id="arrow_box_0"></span>
            <span class="arrow_box wg_srzf_arrow" id="arrow_box_1"></span>
        </div>
        <div class="title_name x_title">纵轴：并联体系/用户付薪
        </div>
        <div class="axis_content y_content wg_content">
            <div id="ec03_line" style="width: 100%;height: 100%"></div>
            <div id="ec04_line" style="width: 100%;height: 100%"></div>
        </div>
    </div>
</div>
</body>
<script src="${ctx}/690/js/jquery-3.3.1.min.js"></script>
<script src="${ctx}/690/js/echarts-4.2.0.js"></script>
<script src="${ctx}/690/js/UEcommon.js"></script>
<script src="${ctx}/690/js/URLcomn.js"></script>
<script src="${ctx}/690/js/chartsCom.js"></script>
<script src="${ctx}/690/js/cdwl-wg-2.js"></script>
</html>