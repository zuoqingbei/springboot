<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${ctx}/690/css/reset.css">
    <link rel="stylesheet" href="${ctx}/690/css/common.css">
    <!-- <link rel="stylesheet" href="css/yhxv.css"> -->
    <link rel="stylesheet" href="${ctx}/690/css/topNav.css">
    <link rel="stylesheet" href="${ctx}/690/css/fhxv.css">
    <link rel="stylesheet" href="${ctx}/690/css/datepiker.css">
    <link rel="icon" type="image/x-icon" href="${ctx}/690/images/favicon.ico" />
    <script>
        	let ctx = '${ctx}';
        </script>
    <script src="${ctx}/690/js/jquery-3.3.1.min.js"></script>
    <script src="${ctx}/690/js/userInfo.js"></script>
    <title>小微分类升级驱动体系</title>
    <style>
        .arrow{
            width: 14px;
            height: 17px;
            position: absolute;
            z-index: 999;
        }
        @media (min-width: 1360px) {
            .arrow_up{
                background: url('${ctx}/690/images/arrow_up.png') no-repeat;
                background-size: 100% 100%;
                top: 37%;
                left: 14.5%;
            }
            .arrow_right{
                background: url("${ctx}/690/images/arrow_right.png") no-repeat;
                background-size: 100% 100%;
                bottom: 14.2%;
                right: 0.7%;
                width: 17px;
                height: 14px;
            }
            .turnup {
                position: relative;
                height: 73.6%;
                /* border-bottom: 1px solid var(--borderColor); */
                /* background: url("${ctx}/690/images/fhxw_y1.jpg") no-repeat; */
                /* background-size: 100% 100%; */
            }
            .yearBox {
                height: 11.7%;
            }
            .turndown{
                height: 24%;
                position: relative;
                background: url("${ctx}/690/images/fhxw_y2.jpg") no-repeat;
                background-size: 104% 100%;
                background-position: -5px 0%;
            }
        }

        @media (min-width: 1400px) {
            .y_axis_2 {
                left: 31.35%;
            }
            .y_axis_3 {
                left: 81.55%;
            }
            .x_axis {
                bottom: 13.9%;
            }
            .x_axis2 {
                bottom: 3.6%;
            }
        }
        /* .turnbox {
            height: 17.5%;
            margin: 2% 10px 0% 0;
        } */
        .summary span{
            float:left;
        }
        
        .p_on_tit {
            font-size: .875rem;
        }
        .btn_next{
            position: absolute;
            padding: .5rem;
            right: 1%;
            top: 53%;
            font-size: 3rem;
            color: #fff;
            background: rgba(1,1,1,.3);
            display: none;
            z-index: 9999;
            cursor: pointer;    
        }
        .btn_next:hover{
            background: rgba(1,1,1,.7);
        }
        .m_right_scroll:hover .btn_next{
            display: block;
        }
        .turnbox{
            background: #1b294e;
        }
        .boxcnt{
            background: transparent;
            transform: scale(.9);
        }
        .turndown{
            background: transparent;
        }
        .line_3{
            background-image: url('${ctx}/690/images/LeftArrow2.png')
        }
        .turnbox_s_n{
            height: 22%;
            margin: 4% 0 0 0 !important;
            padding: 2% 10px 0 0;
            /* border-top: 1px solid var(--borderColor); */
            background: transparent;
        }
        .turnbox_s_n>div{
            width: 96%;
            height: 100%;
            margin-left: 6px;
            background: #1b294e;
        }
        .turnbox_s{
            background: transparent;
        }
        .turnbox_s_l{
            width: 100%;
            height: 80%;
            background: #1b294e;
        }
        .boxcnt_s {
            height: 100%;
        }
        .int input {
            font-size: 1rem;
        }
        .int span {
            font-size: 1rem;
        }
        h2.tit{
            padding: 5px 0;
        }
        .int{
            margin-left: 8px !important;
        }
        .numbs{
            font-family: Arial;
        } 
        @media(max-width:1400px){
            .turnbox_s_n {
                height: 27%;
                width: 83%;
            }
            .block_scroll{
                transform: scale(.8);
            }
            .turnbox_s_n>div {
                width: 96.5%;
            }
        }
        @media (max-width : 1400px) and (max-height: 700px){
            .x_axis {
                bottom: 13.1%;
            }
            .x_axis2 {
                bottom: 3.2%;
            }
            .turnbox_s_n {
                margin: 2.2% 0 0 0 !important;
            }
            .turnbox_s {
                height: 63%;
                padding-top: 4%;
            }
        }
        @media (max-width : 1400px) and (min-height: 701px){
            .x_axis {
                bottom: 14%;
            }
            .x_axis2 {
                bottom: 3.6%;
            }
            .m_left_oth {
                margin-top: 2.5%;
            }
            .turnbox {
                margin: 1.5% 10px 0% 0 !important;
            }
            .turnbox_s {
                height: 55%;
                padding-top: 0%;
            }
            .turnbox_s_n {
                margin: 3% 0 0 0 !important;
            }
        }
        .tables {
            border-bottom: 0;
        }
        
        /* @-moz-document url-prefix() {
            @media (max-width: 1400px) and (min-height: 701px) {
                .turnbox_s_n {
                    margin: 3% 0 0 0 !important;
                }
            }
        } */
        </style>
</head>

<body>

    <div class="nav_btns">
        <div class="pt_btn home_btn" id="home"></div>
        <div class="pt_btn" id="yhxw">用户小微</div>
        <div class="pt_btn" id="cdwl">触点网络</div>
        <div class="pt_btn pt_btn_active" id="fhxw">孵化小微</div>
    </div>
    <!-- <div class="arrow arrow_up"></div>
    <div class="arrow arrow_right"></div> -->
    <div class="x_axis"></div>
    <div class="x_axis2"></div>
    <div class="y_axis"></div>
    <div class="y_axis y_axis_2"></div>
    <div class="y_axis y_axis_3"></div>
    <header>
        <h2 class="title">三生 创业孵化小微分类驱动体系</h2>
        <div class="time"><span></span>-<span></span>-<span></span>&nbsp;&nbsp;<span></span>:<span></span>:<span></span></div>
    </header>
    <div class="subnav">
        <div class="row1 ">
            <div class="industry">
                <label for="industryIpt" class="lable">产业 :</label>
                <select id="industryIpt" class="titleIpt">

                </select>
            </div>
            <div class="industry choose_xw">
                <label for="select_xwcode" class="lable">用户小微 :</label>
                <select id="select_xwcode" class="titleIpt">
                    <!-- <option value="ALL">全部小微</option> -->
                </select>
            </div>
            <div class="date">
                <label for="dateIpt" class="lable datelab">时间 :</label>
                <input onchange="dateChange()" type="text" id="dateIpt" class="titleIpt" readonly="readonly">
            </div>
            <div id="select" class="box_sp">查询</div>
            <!-- <div class="legend">
                <span class="star five"></span><span>5星</span>
                <span class="star four"></span><span>4星</span>
                <span class="star three"></span><span>3星</span>
                <span class="star two"></span><span>2星</span>
                <span class="star one"></span><span>1星</span>
            </div> -->
            <div class="ill">小微 : 轮次时间—估值/融资额/生态收入</div>
            <div class="switch">
                <div class="switch_2">估值</div>
                <div class="switch_1">融资速度</div>
            </div>
        </div>
        <!-- <div class="row2">
            <div class="name index_name_div"></div>
            <div class="level">
                <span>目标 :</span>
                <span class="levelStar levelStar_1"></span>
                <span>预算 :</span>
                <span class="levelStar levelStar_2"></span>
                <span>实际 :</span>
                <span class="levelStar levelStar_3"></span>
            </div>
            <div class="summary" style="display:none;">
                <span>结论:</span>
                <input type="text" class="jielun1" id="summaryIpt" placeholder="">
            </div>
        </div> -->
    </div>
    <main>
        <!-- <div class="yearBox">
            <h2 class="tit">2019年目标</h2>
            <div class="int">
                <span>引爆目标</span>
                <input class="jielun3 next_year" type="text">
            </div>
            <div class="int">
                <span>小微升级</span>
                <input class="jielun4 next_year" type="text">
            </div>
        </div> -->
        <div class="m_left">
            <div class="m_left_top">
                <div class="column_top nextYearNews">
                    <div class="column_1_goal box_sp flex_center">结论</div>
                    <div class="column_2_long tittable s_3 tittable_all jielun_main"></div>
                </div>
            </div>
            <div class="m_left_oth">
                <div class="turnup">
                    <p class="left_title">融资轮次</p>
                    <div class="turnbox">
                        <div class="titilebox box_sp">独角兽/IPO</div>
                        <div class="boxcnt">
                            进入独角兽排行</br>
                            成为独角兽
                        </div>
                    </div>
                    <div class="turnbox">
                        <div class="titilebox box_sp">C轮</div>
                        <div class="boxcnt">
                            正现金流</br>
                            实现盈利，生态收入倍数增长</br>
                        </div>
                    </div>
                    <div class="turnbox">
                        <div class="titilebox box_sp">B轮</div>
                        <div class="boxcnt">
                            生态吸力，收入倍数增长</br>
                            用户及资源方蜂拥而至
                        </div>
                    </div>
                    <div class="turnbox">
                        <div class="titilebox box_sp">A轮</div>
                        <div class="boxcnt">
                            有增值分享空间</br>
                            盈利模式清晰</br>
                            有用户粘性
                        </div>
                    </div>
                    <div class="turnbox">
                        <div class="titilebox box_sp">天使轮</div>
                        <div class="boxcnt">
                            创业团队，跟投对赌</br>
                            市场机会空间大
                        </div>
                    </div>

                    <div class="line line_1">
                        <img src="${ctx}/690/images/Leftup.png" alt="" class="img_up">
                        加速期
                        <img src="${ctx}/690/images/Leftdown.png" alt="" class="img_down">
                    </div>
                    <div class="line line_2">
                        A轮及以下
                    </div>
                </div>
                <div class="turndown">
                    <div class="turnbox turnbox_s">
                        <div class="titilebox box_sp titilebox_s">未引入社会化资本</div>
                        <div class="turnbox_s_l">
                            <div class="boxcnt boxcnt_s">
                                成立一年一上</br>
                                成立半年以上
                            </div>
                        </div>
                    </div>
                    <div class="turnbox turnbox_s_n">
                        <div>
                            <div class="boxcnt boxcnt_s_n">
                                成立半年以内
                            </div>
                        </div>
                    </div>
                    <div class="line line_3">
                        孵化期
                    </div>
                    <div class="line line_4">
                        新冒出
                    </div>
                </div>
            </div>
        </div>
        <div class="m_right">
            <span class="left_arrow cut_arrow"></span>
            <span class="right_arrow cut_arrow"></span>
            <div class="column column_1 showPointer">
                <div class="column_top nextYearNews">
                    <div class="column_1_goal box_sp flex_center" id="yearTit">2019年目标</div>
                    <div class="column_2_long tittable s_3" id="ec00_bar"></div>
                    <div class="column_2_short t_s s_3" id="next_input">
                        <span>目标:</span><input type="text" class="jielun1" disabled="disabled" placeholder="引领目标">
                        <span>升级:</span><input type="text" class="jielun2" disabled="disabled" placeholder="行业升级">
                    </div>
                </div>
                <div class="column_oth">
                    <div class="oth_up">
                        <div class="little_title">
                            <div style="display:none;" class="gat">目标/实际</div>
                        </div>
                        <div class="tables lunci1">

                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>

                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="oth_down">
                        <div class="oth_down_up ">
                            <div class="block center_lunci1_1">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="block center_lunci1_2">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="numbs div_nums1">
                                <span class="numsvalue_1_1"><span class="point_line"></span>25</span>
                                <span class="numsvalue_1_2"><span class="point_line"></span>20</span>
                                <span class="numsvalue_1_3"><span class="point_line"></span>15</span>
                                <span class="numsvalue_1_4"><span class="point_line"></span>10</span>
                                <span class="numsvalue_1_5"><span class="point_line"></span>5</span>
                            </div>
                        </div>
                        <div class="oth_down_down">
                            <div class="block center_lunci1_3">
                                <div class="block_tit">

                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="column column_1">
                <div class="column_top">
                    <!-- <h2 class="tit">11月预实差</h2>
                    <div class="int">
                        <span>引领目标</span>
                        <input class="jielun5" type="text">
                    </div>
                    <div class="int">
                        <span>小微升级</span>
                        <input class="jielun6" type="text">
                    </div> -->
                    <div class="column_1_goal">
                        <div class="middle_long_tit box_sp flex_center" id="nowMonth">
                            本月累计预实差
                        </div>
                        <div class="middle_short_tit box_sp flex_center">
                            目标
                        </div>
                    </div>
                    <div class="column_2_long tittable s_3" id="ec01_bar"></div>
                    <div class="column_2_short t_s s_3" id="next_input">
                        <span>目标:</span><input type="text" class="jielun3" disabled="disabled" placeholder="引领目标">
                        <span>升级:</span><input type="text" class="jielun4" disabled="disabled" placeholder="行业升级">
                    </div>
                </div>
                <div class="column_oth">
                    <div class="oth_up">
                        <div class="little_title">

                        </div>
                        <div class="tables lunci7 now_goal">

                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>

                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="oth_down now_goal_down">
                        <div class="oth_down_up ">
                            <div class="block center_lunci7_1">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="block center_lunci7_2">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="numbs div_nums7">
                                <span class="numsvalue_7_1"><span class="point_line"></span>25</span>
                                <span class="numsvalue_7_2"><span class="point_line"></span>20</span>
                                <span class="numsvalue_7_3"><span class="point_line"></span>15</span>
                                <span class="numsvalue_7_4"><span class="point_line"></span>10</span>
                                <span class="numsvalue_7_5"><span class="point_line"></span>5</span>
                            </div>
                        </div>
                        <div class="oth_down_down">
                            <div class="block center_lunci7_3">
                                <div class="block_tit">

                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="column column_1">
                <div class="column_top">
                    <!-- <h2 class="tit">11月预实差</h2>
                    <div class="int">
                        <span>引领目标</span>
                        <input class="jielun5" type="text">
                    </div>
                    <div class="int">
                        <span>小微升级</span>
                        <input class="jielun6" type="text">
                    </div> -->
                    <div class="column_1_goal">
                        <div>

                        </div>
                        <div class="middle_short_tit box_sp flex_center">
                            承接
                        </div>
                    </div>
                    <div class="column_2_long tittable s_3" id="ec02_bar"></div>
                    <div class="column_2_short t_s s_3" id="next_input">
                        <span>承接:</span><input type="text" class="jielun5" disabled="disabled" placeholder="引领目标">
                        <span>升级:</span><input type="text" class="jielun6" disabled="disabled" placeholder="行业升级">
                    </div>
                </div>
                <div class="column_oth">
                    <div class="oth_up">
                        <div class="little_title">

                        </div>
                        <div class="tables lunci8 now_get">

                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>

                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="oth_down now_get_down">
                        <div class="oth_down_up ">
                            <div class="block center_lunci8_1">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="block center_lunci8_2">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="numbs div_nums8">
                                <span class="numsvalue_8_1"><span class="point_line"></span>25</span>
                                <span class="numsvalue_8_2"><span class="point_line"></span>20</span>
                                <span class="numsvalue_8_3"><span class="point_line"></span>15</span>
                                <span class="numsvalue_8_4"><span class="point_line"></span>10</span>
                                <span class="numsvalue_8_5"><span class="point_line"></span>5</span>
                            </div>
                        </div>
                        <div class="oth_down_down">
                            <div class="block center_lunci8_3">
                                <div class="block_tit">

                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="column column_1">
                <div class="column_top">
                    <!-- <h2 class="tit">11月预实差</h2>
                    <div class="int">
                        <span>引领目标</span>
                        <input class="jielun5" type="text">
                    </div>
                    <div class="int">
                        <span>小微升级</span>
                        <input class="jielun6" type="text">
                    </div> -->
                    <div class="column_1_goal">
                        <div>

                        </div>
                        <div class="middle_short_tit box_sp flex_center">
                            实际
                        </div>
                    </div>
                    <div class="column_2_long tittable s_3" id="ec03_bar"></div>
                    <div class="column_2_short t_s s_3" id="next_input">
                        <span>实际:</span><input type="text" class="jielun7" disabled="disabled" placeholder="引领目标">
                        <span>升级:</span><input type="text" class="jielun8" disabled="disabled" placeholder="行业升级">
                    </div>
                </div>
                <div class="column_oth">
                    <div class="oth_up">
                        <div class="little_title">

                        </div>
                        <div class="tables lunci2 now_fact">

                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>

                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="block">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="oth_down now_fact_down">
                        <div class="oth_down_up ">
                            <div class="block center_lunci2_1">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="block center_lunci2_2">
                                <div class="block_tit">
                                    0/0
                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                            <div class="numbs div_nums2">
                                <span class="numsvalue_2_1"><span class="point_line"></span>25</span>
                                <span class="numsvalue_2_2"><span class="point_line"></span>20</span>
                                <span class="numsvalue_2_3"><span class="point_line"></span>15</span>
                                <span class="numsvalue_2_4"><span class="point_line"></span>10</span>
                                <span class="numsvalue_2_5"><span class="point_line"></span>5</span>
                            </div>
                        </div>
                        <div class="oth_down_down">
                            <div class="block center_lunci2_3">
                                <div class="block_tit">

                                </div>
                                <div class="block_scroll">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 滚动区域 -->
            <div class="m_right_scroll">
                <div class="btn_next">&gt;</div>
                <div class="screen">
                    <div class="column column_2 t1Mouth showPointer">
                        <div class="column_top">
                            <!-- <h2 class="tit">12月预算</h2>
                            <div class="int">
                                <span>引领目标 </span>
                                <input class="jielun7" type="text">
                            </div>
                            <div class="int">
                                <span>小微升级</span>
                                <input class="jielun8" type="text">
                            </div> -->
                            <div class="column_1_goal box_sp flex_center" id="monthT1">T+1月</div>
                            <div class="column_2_long tittable s_3" id="ec04_bar"></div>
                            <div class="column_2_long tittable s_3" id="ec04_bar_img"></div>
                            <div class="column_2_short t_s s_3" id="next_input">
                                <span>目标:</span><input type="text" class="jielun9" disabled="disabled" placeholder="引领目标">
                                <span>升级:</span><input type="text" class="jielun10" disabled="disabled" placeholder="行业升级">
                            </div>
                        </div>
                        <div class="column_oth">
                            <div class="oth_up">
                                <div class="little_title">

                                </div>
                                <div class="tables lunci3">
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="oth_down">
                                <div class="oth_down_up ">
                                    <div class="block center_lunci3_1">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block center_lunci3_2">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="numbs div_nums3">
                                        <span class="numsvalue_3_1"><span class="point_line"></span>25</span>
                                        <span class="numsvalue_3_2"><span class="point_line"></span>20</span>
                                        <span class="numsvalue_3_3"><span class="point_line"></span>15</span>
                                        <span class="numsvalue_3_4"><span class="point_line"></span>10</span>
                                        <span class="numsvalue_3_5"><span class="point_line"></span>5</span>
                                    </div>
                                </div>
                                <div class="oth_down_down">
                                    <div class="block center_lunci3_3">
                                        <div class="block_tit">

                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="column column_3 t2Mouth showPointer">
                        <div class="column_top">
                            <!-- <h2 class="tit">2019年1月预算</h2>
                            <div class="int">
                                <span>引领目标</span>
                                <input class="jielun9" type="text">
                            </div>
                            <div class="int">
                                <span>小微升级</span>
                                <input class="jielun10" type="text">
                            </div> -->
                            <div class="column_1_goal box_sp flex_center" id="monthT2">T+2月</div>
                            <div class="column_2_long tittable s_3" id="ec05_bar"></div>
                            <div class="column_2_long tittable s_3" id="ec05_bar_img"></div>
                            <div class="column_2_short t_s s_3" id="next_input">
                                <span>目标:</span><input type="text" class="jielun11" disabled="disabled" placeholder="引领目标">
                                <span>升级:</span><input type="text" class="jielun12" disabled="disabled" placeholder="行业升级">
                            </div>
                        </div>
                        <div class="column_oth">
                            <div class="oth_up">
                                <div class="little_title">

                                </div>
                                <div class="tables lunci4">
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="oth_down">
                                <div class="oth_down_up ">
                                    <div class="block center_lunci4_1">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block center_lunci4_2">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="numbs div_nums4">
                                        <span class="numsvalue_4_1"><span class="point_line"></span>25</span>
                                        <span class="numsvalue_4_2"><span class="point_line"></span>20</span>
                                        <span class="numsvalue_4_3"><span class="point_line"></span>15</span>
                                        <span class="numsvalue_4_4"><span class="point_line"></span>10</span>
                                        <span class="numsvalue_4_5"><span class="point_line"></span>5</span>
                                    </div>
                                </div>
                                <div class="oth_down_down">
                                    <div class="block center_lunci4_3">
                                        <div class="block_tit">

                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="column column_2 q1Quarter showPointer">
                        <div class="column_top">
                            <!-- <h2 class="tit">2019年Q1目标</h2>
                            <div class="int">
                                <span>引领目标</span>
                                <input class="jielun11" type="text">
                            </div>
                            <div class="int">
                                <span>小微升级</span>
                                <input class="jielun12" type="text">
                            </div> -->
                            <div class="column_1_goal box_sp flex_center" id="Q1Tit">Q1季度</div>
                            <div class="column_2_long tittable s_3" id="ec06_bar"></div>
                            <div class="column_2_long tittable s_3" id="ec06_bar_img"></div>
                            <div class="column_2_short t_s s_3" id="next_input">
                                <span>目标:</span><input type="text" class="jielun13" disabled="disabled" placeholder="引领目标">
                                <span>升级:</span><input type="text" class="jielun14" disabled="disabled" placeholder="行业升级">
                            </div>
                        </div>
                        <div class="column_oth">
                            <div class="oth_up">
                                <div class="little_title">

                                </div>
                                <div class="tables lunci5">
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="oth_down">
                                <div class="oth_down_up">
                                    <div class="block center_lunci5_1">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block center_lunci5_2">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="numbs div_nums5">
                                        <span class="numsvalue_5_1"><span class="point_line"></span>25</span>
                                        <span class="numsvalue_5_2"><span class="point_line"></span>20</span>
                                        <span class="numsvalue_5_3"><span class="point_line"></span>15</span>
                                        <span class="numsvalue_5_4"><span class="point_line"></span>10</span>
                                        <span class="numsvalue_5_5"><span class="point_line"></span>5</span>
                                    </div>
                                </div>
                                <div class="oth_down_down">
                                    <div class="block center_lunci5_3">
                                        <div class="block_tit">

                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="column column_3 q2Quarter showPointer">
                        <div class="column_top">
                            <!-- <h2 class="tit">2019年Q2目标</h2>
                            <div class="int">
                                <span>引领目标</span>
                                <input class="jielun13" type="text">
                            </div>
                            <div class="int">
                                <span>小微升级</span>
                                <input class="jielun14" type="text">
                            </div> -->
                            <div class="column_1_goal box_sp flex_center" id="Q2Tit">Q2季度</div>
                            <div class="column_2_long tittable s_3" id="ec07_bar"></div>
                            <div class="column_2_long tittable s_3" id="ec07_bar_img"></div>
                            <div class="column_2_short t_s s_3" id="next_input">
                                <span>目标:</span><input type="text" class="jielun15" disabled="disabled" placeholder="引领目标">
                                <span>升级:</span><input type="text" class="jielun16" disabled="disabled" placeholder="行业升级">
                            </div>
                        </div>
                        <div class="column_oth">
                            <div class="oth_up">
                                <div class="little_title">

                                </div>
                                <div class="tables lunci6">
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="oth_down">
                                <div class="oth_down_up">
                                    <div class="block center_lunci6_1">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="block center_lunci6_2">
                                        <div class="block_tit">
                                            0/0
                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                    <div class="numbs div_nums6">
                                        <span class="numsvalue_6_1"><span class="point_line"></span>25</span>
                                        <span class="numsvalue_6_2"><span class="point_line"></span>20</span>
                                        <span class="numsvalue_6_3"><span class="point_line"></span>15</span>
                                        <span class="numsvalue_6_4"><span class="point_line"></span>10</span>
                                        <span class="numsvalue_6_5"><span class="point_line"></span>5</span>
                                    </div>
                                </div>
                                <div class="oth_down_down">
                                    <div class="block center_lunci6_3">
                                        <div class="block_tit">

                                        </div>
                                        <div class="block_scroll">

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <div class="addxname">估值（亿）</div>
    <div class="alertbox">

    </div>
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
        <div class="menu_item flex_center">孵化小微</div>
    </div> -->
    <!-- <div class="submitbox box_sp flex_center">
        <div id="reset" class="flex_center">编辑</div>
        <div id="submit" class="flex_center">提交</div>
        <div class="submitbox_btn flex_center">◀</div>
    </div> -->
    
    <script src="${ctx}/690/js/echarts-4.2.0.js"></script>
    <script src="${ctx}/690/js/jquery.date_input.pack.js"></script>
    <script src="${ctx}/690/js/chartsCom.js"></script>
    <script src="${ctx}/690/js/URLcomn.js"></script>
    <script src="${ctx}/690/js/UEcommon.js"></script>
    <script src="${ctx}/690/js/common.js"></script>
    <script src="${ctx}/690/js/fhxv.js"></script>
    <script src="${ctx}/690/js/topNav.js"></script>

</body>
<script>
    $(function () {
        $(".switch").find("div").on("click", function () {
            $(".switch").find("div").removeClass("switch_2").addClass("switch_1");
            $(this).removeClass("switch_1").addClass("switch_2");
            guZhiRongsu = $(this).text();
            if (guZhiRongsu == '估值') {
                $('.addxname').text('估值（亿）');
            } else {
                $('.addxname').text('融资速度');
            }
            searchFunction();
        });
        module = "孵化";
        page_num = 1;
        //绑定提交事件
        // $("#submit").on("click", submitComment);
        // $("#dateIpt").val(formatDate(new Date()));
        // $("#reset").on("click", editDom);
        $("#select").on("click", function () {
            $('.right_arrow').hide();
            $('.left_arrow').show();
            searchFunction();
        });
        //绑定融资轮次悬浮事件
        // hoverFunForRzlcBlock();

        $(function () {
            initBackParams();
            getDateByCommonInterface("hl_690_dp_industryinfo", "UCode::" + userInfo.userID, setIndustryInfo);
            // searchFunction();
        });
        // 轮播按钮
        $('.btn_next').click(function () {
            wfscroll();
        })
    })


</script>

</html>