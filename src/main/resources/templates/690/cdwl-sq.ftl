<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${ctx}/690/css/reset.css">
    <link rel="stylesheet" href="${ctx}/690/css/common.css">
    <link rel="stylesheet" href="${ctx}/690/css/topNav.css">
    <link rel="stylesheet" href="${ctx}/690/css/yhxv.css">
    <link rel="stylesheet" href="${ctx}/690/css/cdwl-sq.css">
    <link rel="stylesheet" href="${ctx}/690/css/datepiker.css">
    <link rel="stylesheet" href="${ctx}/690/css/consumer_micro.css">
    <link rel="icon" type="image/x-icon" href="${ctx}/690/images/favicon.ico" />
    <script src="${ctx}/690/js/userInfo.js"></script>
    <title>小微分类升级驱动体系</title>
    <style>
        .arrow{    
            width: 16px;
            height:17px;
            position: absolute;
            z-index: 999;
        }
        /*.arrow_up{
            background: url("${ctx}/690/images/arrow_up.png") no-repeat;
            background-size: cover;
            top: 38%;
            left: 14.44%;
        }
        .arrow2 {
            left: -8px;
            top: -1.5%;
        }
        .arrow_right{
            background: url(${ctx}/690/images/arrow_right.png) no-repeat;
            background-size: cover;
            top: 93.3%;
            right: 0.5%;
        }*/
        div.addline2 {
            top: 2.4%;
            right: -6%;
        }
        div.addline3{
            top: -0.7%;
            height: 120%;
            right: -2.8%;
        }
        /*.oth_s .addline{
            height: 95%;
        }*/
        .switch{    
            width: 1.3rem;
            height: 1.3rem;
            position: absolute;
            left: -11.5%;
            top: 25%;
            margin-left: 2%;
            cursor: pointer;
        }
        .switch_1{
            background: url('${ctx}/690/images/check.png');
            background-size: 1.3rem 1.3rem;
        }
        .switch_2{
            border: 1px solid var(--borderColor);
            color: #0284b5;
        }
        .industry_wg{
            position: relative;
            margin-left: 1%;
        }
        .area_4 {
            height: 87.2%;
        }
        #select_sq option{
            height:50%;
        }
        .column_2 {
            width: 57%;
            height: 101%;
        }
        .oth_2 {
            width: 33%;
            padding-top: 4.7%;
            float: left;
            height: 74.5%;
        }
        .icon_box .yhxw_legend {
            width: 32%;
            margin-right: 2%;
            float: right;
        }
        .area_1, .area_4>.column_oth_up {
            height: 90.8%;
        }
        .numbs .point_line {
            top: -0.2rem;
            left: 38%;
            width: 0.3rem;
            height: 0.3rem;
            background: var(--borderColor);
            border-radius: 50%;
        }
        .numbs>span {
            line-height: 1.8rem;
        }
        .area_2, .area_3, .area_4 {
            height: 87.4%;
        }
        .t_s input {
            font-size: 1rem;
        }
        #dateIpt {
            margin-left: 5%;
            padding: 2px 0 3px 10px;
        }
        /*.block_scroll {
            width: 99%;
        }*/
        #ec00_bar {
            height: 56%;
        }
        .column_1 .s_3 {
            margin-top: 1.3%;
        }
        #ZLMB{
            text-align: center;
            box-sizing: border-box;
            padding: 3.6rem 1rem;
            font-size: 1.7rem;
            color: #0083b3;
            overflow:hidden;
        }
        #ec04_bar,#ec05_bar,#ec06_bar,#ec07_bar{
            visibility: hidden;
            position: relative;
        }
        #ec04_bar_img,#ec05_bar_img,#ec06_bar_img,#ec07_bar_img{
            position: absolute;
            top: 26%;
            left: 1%;
        }
        .column_top {
            position: relative;
        }
        .m_top_content{
            display: flex;
        }
        .upgrade.t_s span{
            line-height: 1.8rem;
        }
        .column_mb {
            height: 68%;
            padding-top: 0;
            margin-top: 20%;
        }
        .column_scroll .column_oth {
            height: 67.4%;
            padding-top: 0;
            margin-top: 21.3%;
        }
        div.addline1 {
            height: 110%;
            top: -4.2%;
        }
        .gat {
            top: -4.5%;
        }
        .turnup {
            height: 93.2%;
            top: -.8rem;
        }
        .turndown {
            margin-top: -1rem;
        }
        .column_scroll .numbs .point_line {
            top: 0;
        }
        .line_bottom {
            bottom: 4.1%;
        }
        .turnbox {
            height: 17.7%;
            margin-bottom: .1rem;
        }
        .boxcnt {
            padding-left: .2rem;
        }
        @media (max-width:1400px){
            .column_2 .numbs{
                width: 120%;
                margin-left: -6%;
            }
            .column_scroll .numbs{
                width: 105%;
                margin-left: -5%;
            }
            .numbs>span {
                line-height: 2rem;
            }
            .column_scroll .numbs>span {
                line-height: 2.5rem;
            }
        }
        @media screen and (max-height: 768px) and (min-width: 1400px){
            .block_scroll {
                width: 109%;
                left: 16%;
            }
            .turnup {
                top: .15rem;
                height: 92.7%;
            }
            .turnbox_s {
                margin: 1rem .5rem 0 0;
            }
            .turnbox {
                height: 17.9%;
                margin: 0.01rem 10px 0% 0;
                margin-bottom: 0.3rem;
            }
            .boxcnt {
                height: 67%;
            }
            .line_bottom {
                bottom: 1.9rem;
            }
            div.addline1 {
                height: 123%;
                top: -5.6%;
            }
            div.addline2 {
                top: 2.3%;
            }
            .oth_2 {
                padding-top: 3rem;
                height: 75.25%;
            }
            .column_scroll .column_oth {
                height: 67.5%;
                margin-top: 4.7rem;
            }
            .column_scroll .numbs .point_line {
                top: 0;
            }
            .jdyl {
                bottom: -290%;
            }
        }
        @media screen and (max-height: 768px) and (max-width: 1366px){ 
            .gat {
                top: -5.5%;
            }
            .column_mb {
                height: 67.4%;
                margin-top: 21.4%;
            }
            .oth_2 {
                height: 74.3%;
                padding-top: 5.3%;
            }
            .column_scroll .column_oth {
                height: 66.9%;
                margin-top: 22.3%;
            }
            div.addline2 {
                right: -6.4%;
            }
            div.addline1 {
                height: 115%;
                top: -5%;
            }
            .m_right .upgrade.t_s .beforeText {
                width: 17%;
            }
            .t_s input {
                width: 83%;
            }
            .submitbox {
                top: 37.5%;
            }
            .switch {
                top: 21%;
            }
            .column_scroll .numbs .point_line {
                top: 0rem;
            }
            .block_scroll {
                width: 109%;
                left: 1rem;
            }
            .turnup {
                top: -.4rem;
                height: 93%;
            }
            .line_bottom {
                bottom: 4%;
            }
            .turndown {
                margin-top: -.7rem;
            }
            .turnbox {
                margin-bottom: .03rem;
            }
        }
        @media (max-height: 700px){
            .line_bottom {
                bottom: 2.5%;
            }
            .oth_2 {
                height: 75.4%;
                padding-top: 5.4%;
            }
            .column_scroll .column_oth {
                height: 66.4%;
            }
            .column_scroll .numbs .point_line {
                top: 0;
            }
            .jdyl {
                bottom: -410%;
            }
            .column_scroll .jdyl {
                bottom: -500%;
            }
            .turnup {
                top: .4rem;
                height: 92.7%;
            }
            div.addline1 {
                top: -7.5%;
            }
            div.addline3 {
                top: -0.5%;
            }
            .column_mb {
                height: 66.9%;
            }
            .turnbox {
                margin-bottom: .02rem;
            }
            .turndown {
                margin-top: 0;
            }
        }
        @media (max-width: 1400px) and (max-height: 700px) {
            .area_2, .area_3, .area_4 {
                height: 87% !important;
            }
            .area_2, .area_3, .area_4 {
                height: 87.5% !important;
                padding-top: 0.5%;
            }
        }
        @media (max-width: 1400px) and (min-height: 700px) {
            .jdyl {
                bottom: -330%;
            }
            .column_scroll .jdyl {
                bottom: -400%;
            }
        }
        @-moz-document url-prefix() {
            .column_scroll .column_oth {
                height: 67.6%;
                margin-top: 21.1%;
            }
            @media screen and (max-height: 768px) and (min-width: 1400px){
                .line_bottom {
                    bottom: 3%;
                }
                .oth_2 {
                    height: 75.5%;
                }
                .turnup {
                    top: .8%;
                }
                .column_scroll .column_oth {
                    height: 67.5%;
                    margin-top: 20.8%;
                }
            }
            @media (max-width: 1400px) and (min-height: 701px) {
                .oth_2 {
                    padding-top: 5.3%;
                }
                .column_scroll .column_oth {
                    height: 66.8%;
                    margin-top: 22.4%;
                }
                .turnup {
                    height: 91.5%;
                }
            }
            @media (max-height: 700px) {
                .oth_2 {
                    height: 75.2%;
                    padding-top: 5.3%;
                }
                .column_scroll .column_oth {
                    height: 66.5%;
                    margin-top: 22.1%;
                }
            }
        }

        </style>
</head>

<body>
    <div class="nav_btns">
        <div class="pt_btn home_btn" id="home"></div>
        <div class="pt_btn" id="yhxw">用户小微</div>
        <div class="pt_btn pt_btn_active" id="cdwl">触点网络</div>
        <div class="pt_btn" id="fhxw">孵化小微</div>
    </div>
    <!-- <div class="arrow arrow_right"></div> -->
    <header>
        <h2 class="title">小微分类升级驱动行业主关差（触点网络-商圈）</h2>
        <div class="time"><span></span>-<span></span>-<span></span>&nbsp;&nbsp;<span></span>:<span></span>:<span></span></div>
    </header>
    <!-- <div class="switch">
        <div class="switch_1">商圈</div>
        <div class="switch_2">网格</div>
    </div> -->
    <div class="subnav">
        <div class="row1">
            <div class="industry">
                <label for="industryIpt" class="lable">产业 :</label>
                <select name="" id="select_indust" class="titleIpt industryIpt">
                    <!-- <option value="ALL">全部产业</option> -->
                </select>
            </div>
            <div class="industry industry_wg">
                <div class="switch switch_1"></div>
                <label for="industryIpt" class="lable">商圈 :</label>
                <select name="" id="select_sq" class="titleIpt industryIpt">
                </select>
            </div>
            <div class="industry industry_wg">
                <div class="switch switch_2"></div>
                <label for="industryIpt" class="lable">网格 :</label>
                <select name="" id="select_wg" class="titleIpt industryIpt">
                    <option value='ALL'>全部网格</option>
                </select>
            </div>
            <div class="date">
                <label for="dateIpt" class="lable">时间 :</label>
                <input type="text" id="dateIpt" class="titleIpt dateIpt" readonly="readonly">
            </div>
            <div id="select" class="box_sp select">查询</div>
        </div>
    </div>

    <div class="icon_box">
        <div class="yhxw_ill">纵 : 覆盖率/达标率/五星触点占比</div>
        <div class="yhxw_ill">横 : 首位度/收入增幅/零售增幅&ensp;</div>
        <div class="legend yhxw_legend">
            <span class="star five"></span><span>5星</span>
            <span class="star four"></span><span>4星</span>
            <span class="star three"></span><span>3星</span>
            <span class="star two"></span><span>2星</span>
            <span class="star one"></span><span>1星</span>
        </div>
    </div>

    <main>
        <div class="m_left">
            <div class="m_top">
                <!--  <div class="s_lin1_name"></div>
                  <div class="s_lin1_one">19年目标 :<span>★★★★</span></div>
                  <div class="s_lin1_two">11月目标 :<span>★★★</span></div>
                  <div class="s_lin1_three">11月现状 :<span>★★★★★</span></div>-->
                <!-- <div class="m_top_name">战略目标</div>-->
                <div class="column_1_goal box_sp flex_center title_top" id="CYZ"></div>
                <div class="m_top_content">
                    <div class="s_lin1 s_lin1_one"><span></span></div>
                    <div class="s_lin1 s_lin1_two"><span></span></div>
                    <div class="s_lin1 s_lin1_three"><span></span></div>
                </div>
            </div>
            <div class="m_oth">
                <div class="turnup">
                    <p class="left_title">基础 2个100%</p>
                    <div class="turnbox">
                        <div class="titilebox box_sp">终身触点</div>
                        <div class="boxcnt">
                            全屋解决方案</br>
                            体验迭代形成终身用户
                        </div>
                    </div>
                    <div class="turnbox">
                        <div class="titilebox box_sp">触点Ⅲ级</div>
                        <div class="boxcnt">
                            成套解决方案</br>
                            建立社群
                        </div>
                    </div>
                    <div class="turnbox">
                        <div class="titilebox box_sp">触点Ⅱ级</div>
                        <div class="boxcnt">
                            系统解决方案（前置入口）</br>
                            用户交互
                        </div>
                    </div>
                    <div class="turnbox">
                        <div class="titilebox box_sp">触点Ⅰ级</div>
                        <div class="boxcnt">
                            到村到社区</br>
                            交互方案
                        </div>
                    </div>
                    <div class="turnbox">
                        <div class="titilebox box_sp">触点</div>
                        <div class="boxcnt">
                            产出达标</br>
                            触点覆盖
                        </div>
                    </div>
                </div>
                <div class="turndown">
                    <div class="addline addline3"></div>
                    <div class="turnbox_s flex_center">
                        底线 : 零代理
                    </div>
                </div>
            </div>
        </div>
        <div class="m_right">
            <div class="column_1">
                <div class="column_top">
                    <div class="column_1_goal box_sp flex_center title_top" id="yearMB">
                        2019年目标
                    </div>
                    <!-- <div class="int">
                        <span>引领目标</span>
                        <input type="text">
                    </div>
                    <div class="int">
                        <span>目标承接</span>
                        <input type="text">
                    </div>
                    <div class="int">
                        <span>网络升级</span>
                        <input type="text">
                    </div> -->
                    <div class="column_2_long tittable s_3" id="ec00_bar"></div>
                    <div class="column_2_short t_s s_3 upgrade_0 upgrade">
                        <!-- <input type="text" disabled="disabled" value="行业地位:">
                        <input type="text" disabled="disabled" value="小微升级:"> -->
                    </div>
                </div>

                <div class="column_oth oth_s column_mb">
                    <div class="addline addline1"></div>
                    <div class="gat">
                        升级目标（数量/占比）
                    </div>
                    <div class="column_oth_up up_s area_1">
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                    </div>
                    <div class="column_oth_down up_s">
                        <div class="numbs">
                            <span><span class="point_line"></span>行业增长</span>
                            <span><span class="point_line"></span>达成目标</span>
                            <span><span class="point_line"></span>达成1.2倍</span>
                            <span>
                                <span class="point_line"></span>
                                1.5倍目标
                                <div class="jdyl">&gt;1.5倍GDP目标</div>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="column_2">
                <div class="column_top btn_box">
                    <div class="column_2_long box_sp btn_box title_top" id="thisMonth">
                        <!-- 11月30日累计预实差 -->
                    </div>
                    <span class="left_arrow"></span>
                    <span class="right_arrow"></span>
                    <div class="column_2_short_all">
                        <div class="column_2_short box_sp title_top">
                            目标
                        </div>
                        <div class="column_2_short box_sp title_top">
                            承接
                        </div>
                        <div class="column_2_short box_sp title_top">
                            实际
                        </div>
                    </div>
                    <div class="column_2_long tittable s_3 tittable_center">
                        <div id="ec01_bar" class="chart_content"></div>
                        <div id="ec02_bar" class="chart_content"></div>
                        <div id="ec03_bar" class="chart_content"></div>
                    </div>
                    <div class="column_2_short t_s upgrade_1 upgrade">
                        <!-- <input type="text" disabled="disabled" value="行业地位:">
                        <input type="text" disabled="disabled" value="小微升级:"> -->
                    </div>
                    <div class="column_2_short t_s upgrade_2 upgrade">
                        <!-- <input type="text" disabled="disabled" value="行业地位:">
                        <input type="text" disabled="disabled" value="小微升级:"> -->
                    </div>
                    <div class="column_2_short t_s upgrade_3 upgrade">
                        <!-- <input type="text" disabled="disabled" value="行业地位:">
                        <input type="text" disabled="disabled" value="小微升级:"> -->
                    </div>
                </div>
                <div class="column_oth oth_2">
                    <div class="column_oth_up area_2">
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                    </div>
                    <div class="column_oth_down up_s">
                        <div class="numbs">
                            <span><span class="point_line"></span></span>
                            <span><span class="point_line"></span></span>
                            <span><span class="point_line"></span></span>
                            <span><span class="point_line"></span></span>
                        </div>
                    </div>
                </div>
                <div class="column_oth oth_2">
                    <div class="column_oth_up area_3">
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                    </div>
                    <div class="column_oth_down up_s">
                        <div class="numbs">
                            <span><span class="point_line"></span>行业增长</span>
                            <span><span class="point_line"></span>达成目标</span>
                            <span><span class="point_line"></span>达成1.2倍</span>
                            <span>
                                <span class="point_line"></span>
                                1.5倍目标
                                <div class="jdyl">&gt;1.5倍GDP目标</div>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="column_oth oth_2">
                    <div class="addline addline2"></div>
                    <div class="column_oth_up area_4">
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                        <div class="block">
                            <div class="block_tit">

                            </div>
                            <div class="block_scroll">

                            </div>
                        </div>
                    </div>
                    <div class="column_oth_down up_s">

                        <div class="numbs">
                            <span><span class="point_line"></span></span>
                            <span><span class="point_line"></span></span>
                            <span><span class="point_line"></span></span>
                            <span><span class="point_line"></span></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="column_scroll">
                <div class="btn_next">&gt;</div>
                <div class="column_screen">
                    <div class="column_3">
                        <div class="column_top">
                            <div class="column_2_long box_sp t1_tit title_top" id="NextMonth1">
                                T+1月
                            </div>
                            <div class="column_2_short_all">
                                <div class="column_2_short box_sp s_3 title_top">
                                    承接
                                </div>
                            </div>
                            <div class="column_2_long tittable s_3" id="ec04_bar"></div>
                            <div class="column_2_long tittable s_3" id="ec04_bar_img"></div>
                            <div class="column_2_short t_s s_3 upgrade_4 upgrade">
                                <!-- <input type="text" disabled="disabled" value="行业地位:">
                                <input type="text" disabled="disabled" value="小微升级升级:"> -->
                            </div>
                        </div>

                        <div class="column_oth">
                            <div class="column_oth_up area_5">
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                            </div>
                            <div class="column_oth_down up_s">
                                <div class="numbs">
                                    <span><span class="point_line"></span>行业增长</span>
                                    <span><span class="point_line"></span>达成目标</span>
                                    <span><span class="point_line"></span>达成1.2倍</span>
                                    <span>
                                        <span class="point_line"></span>
                                        1.5倍目标
                                        <div class="jdyl">&gt;1.5倍GDP目标</div>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="column_3">
                        <div class="column_top">
                            <div class="column_2_long box_sp t2_tit title_top" id="NextMonth2">
                                T+2月
                            </div>
                            <div class="column_2_short_all">
                                <div class="column_2_short box_sp s_3 title_top">
                                    承接
                                </div>
                            </div>
                            <div class="column_2_long tittable s_3 " id="ec05_bar"></div>
                            <div class="column_2_long tittable s_3 " id="ec05_bar_img"></div>
                            <div class="column_2_short t_s s_3 upgrade_5 upgrade">
                                <!-- <input type="text" disabled="disabled" value="行业地位:">
                                <input type="text" disabled="disabled" value="小微升级:"> -->
                            </div>
                        </div>

                        <div class="column_oth">
                            <div class="column_oth_up area_6">
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                            </div>
                            <div class="column_oth_down up_s">
                                <div class="numbs">
                                    <span><span class="point_line"></span>行业增长</span>
                                    <span><span class="point_line"></span>达成目标</span>
                                    <span><span class="point_line"></span>达成1.2倍</span>
                                    <span>
                                        <span class="point_line"></span>
                                        1.5倍目标
                                        <div class="jdyl">&gt;1.5倍GDP目标</div>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="column_3">
                        <div class="column_top">
                            <div class="column_2_long box_sp title_top" id="NextJidu1">
                                2019年Q1季度
                            </div>
                            <div class="column_2_short_all">
                                <div class="column_2_short box_sp s_3 title_top">
                                    目标
                                </div>
                            </div>
                            <div class="column_2_long tittable s_3 " id="ec06_bar"></div>
                            <div class="column_2_long tittable s_3 " id="ec06_bar_img"></div>
                            <div class="column_2_short t_s s_3 upgrade_6 upgrade">
                                <!-- <input type="text" disabled="disabled" value="行业地位:">
                                <input type="text" disabled="disabled" value="小微升级:"> -->
                            </div>
                        </div>

                        <div class="column_oth">
                            <div class="column_oth_up area_7">
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                            </div>
                            <div class="column_oth_down up_s">
                                <div class="numbs">
                                    <span><span class="point_line"></span>行业增长</span>
                                    <span><span class="point_line"></span>达成目标</span>
                                    <span><span class="point_line"></span>达成1.2倍</span>
                                    <span>
                                        <span class="point_line"></span>
                                        1.5倍目标
                                        <div class="jdyl">&gt;1.5倍GDP目标</div>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="column_3">
                        <div class="column_top">
                            <div class="column_2_long box_sp title_top" id="NextJidu2">
                                2019年Q2季度
                            </div>
                            <div class="column_2_short_all">
                                <div class="column_2_short box_sp s_3 title_top">
                                    目标
                                </div>
                            </div>
                            <div class="column_2_long tittable s_3 " id="ec07_bar"></div>
                            <div class="column_2_long tittable s_3 " id="ec07_bar_img"></div>
                            <div class="column_2_short t_s s_3 upgrade_7 upgrade">
                                <!-- <input type="text" disabled="disabled" value="行业地位:">
                                <input type="text" disabled="disabled" value="小微升级:"> -->
                            </div>
                        </div>

                        <div class="column_oth">
                            <div class="column_oth_up area_8">
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                                <div class="block">
                                    <div class="block_tit">

                                    </div>
                                    <div class="block_scroll">

                                    </div>
                                </div>
                            </div>
                            <div class="column_oth_down up_s">
                                <div class="numbs">
                                    <span><span class="point_line"></span>行业增长</span>
                                    <span><span class="point_line"></span>达成目标</span>
                                    <span><span class="point_line"></span>达成1.2倍</span>
                                    <span>
                                        <span class="point_line"></span>
                                        1.5倍目标
                                        <div class="jdyl">&gt;1.5倍GDP目标</div>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <!-- 其他项 -->
    <div class="addxname">目标</div>
    <div class="line_bottom"></div>
    <!--   <div class="leftnav">
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
        <div class="menu_item flex_center">孵化小微</div>
    </div>-->
    <!-- <div class="submitbox box_sp flex_center">
        <div id="edit" class="flex_center reset">编辑</div>
        <div id="submit" class="flex_center">提交</div>
        <div class="submitbox_btn flex_center">◀</div>
    </div> -->
    <!--
    <div class="mask"></div>
    <div class="chart_box">
        <div class="chart chart_short">
            <div class="content_left_name echarts_name chart_title">首位度对比</div>
            <div id="ec01_bar" class="chart_content"></div>
        </div>
        <div class="chart chart_short">
            <div class="content_left_name echarts_name chart_title">收入增幅对比</div>
            <div id="ec02_bar" class="chart_content"></div>
        </div>
        <div class="chart chart_short">
            <div class="content_left_name echarts_name chart_title">零售增幅对比</div>
            <div id="ec03_bar" class="chart_content"></div>
        </div>
        <div class="chart chart_long">
            <div class="content_left_name echarts_name chart_title">T1 & T2承接对比</div>
            <div id="ec04_bar" class="chart_content"></div>
        </div>
        <div class="chart chart_long">
            <div class="content_left_name echarts_name chart_title">Q1 & Q2 目标对比</div>
            <div id="ec05_bar" class="chart_content"></div>
        </div>
        <div class="hide_chart_btn">
            <img src="${ctx}/690/images/CLOSE.png" alt="">
        </div>
    </div>-->

    <script src="${ctx}/690/js/jquery-3.3.1.min.js"></script>
    <script src="${ctx}/690/js/echarts-4.2.0.js"></script>
    <script src="${ctx}/690/js/jquery.date_input.pack.js"></script>
    <script src="${ctx}/690/js/common.js"></script>
    <script src="${ctx}/690/js/UEcommon.js"></script>
    <script src="${ctx}/690/js/URLcomn.js"></script>
    <script src="${ctx}/690/js/chartsCom.js"></script>
    <script src="${ctx}/690/js/topNav.js"></script>
    <script src="${ctx}/690/js/cdwl.js"></script>
    <script src="${ctx}/690/js/cdwl-sq.js"></script>
    <script>
        $(function () {
            $('.switch_2').click(function () {
                localStorage.setItem('selectData', JSON.stringify({
                    select_indust: $("#select_indust").val(),
                    select_sq: $("#select_sq").val(),
                    select_wg: $("#select_wg").val(),
                    dateIpt: $("#dateIpt").val(),
                    left_arrow: $('.left_arrow').css('display'),
                    fromClick: true
                }));
                location.href = '/bigSreen/sys/v1/cdwl-wg';
            })
            rightScroll();
        })
    </script>
</body>

</html>