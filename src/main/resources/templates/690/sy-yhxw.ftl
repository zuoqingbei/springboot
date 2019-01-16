<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${ctx}/690/css/reset.css">
    <link rel="stylesheet" href="${ctx}/690/css/common.css">
    <link rel="stylesheet" href="${ctx}/690/css/topNav.css">
    <link rel="stylesheet" href="${ctx}/690/css/sy.css">
    <link rel="stylesheet" href="${ctx}/690/css/index.css">
    <link rel="icon" type="image/x-icon" href="${ctx}/690/images/favicon.ico" />
    <script src="${ctx}/690/js/jquery-3.3.1.min.js"></script>
    <script src="${ctx}/690/js/userInfo.js"></script>
    <title>小微分类升级驱动体系</title>
    <style>
        .xAxis_numbs{
            font-family: Arial;
        }
        @media (min-width: 1910px) {
            .legend {
                margin-left: 54.5%;
            }
        }

        main {
            height: 89%;
        }

        .star_last {
            background: none;
        }

        /* .column_top h2 {
            cursor: pointer;
        } */

        /* .block_scroll{
            display: flex;
            align-items: center;
        } */
        .pointer>div {
            float: none;
            /* position: relative; */
        }

        .yhxw-ill {
            position: absolute;
            top: 508%;
            right: 8%;
            font-size: 1rem;
        }

        .legend {
            position: absolute;
            top: 508%;
            right: 30%;
        }

        /*  .turnup{
              background: url("${ctx}/690/images/yhxw-y1.jpg") no-repeat;
              background-size: 100% 100%;
              border-bottom: 1px solid var(--borderColor);
          }
          .turndown{
              height: 10%;
              background: url("${ctx}/690/images/sy-y2.jpg") no-repeat;
              background-size: 100% 100%;
          }*/
        .arrow {
            width: 16px;
            height: 16px;
            position: absolute;
            z-index: 999;
        }

        .arrow_up {
            background: url('${ctx}/690/images/arrow_up.png') no-repeat;
            background-size: cover;
            top: 30%;
            right: 84.55%;
        }

        .arrow_right {
            background: url('${ctx}/690/images/arrow_right.png') no-repeat;
            background-size: cover;
            top: 90.8%;
            right: 0%;
        }

        .column_1 {
            width: 33%;
        }

        .m_right_scroll {
            width: 66%;
        }

        .turnup_up>div {
            height: 98.5%;
            background: url('${ctx}/690/images/yhxw-y1.jpg') no-repeat;
            background-size: 100% 100%;
        }

        .dixian {
            background: url('${ctx}/690/images/yhxw-y2.jpg') no-repeat;
            background-size: 100% 100%;
        }

        .dixian {
            border-right: 1px solid var(--fontColor);
        }

        .turnup {
            position: relative;
            background-size: 100% 101%;
        }

        .dixian {
            border-bottom: 0;
        }

        .column_top {
            border: none;
        }

        /*.scroll .int {
            margin-top: 1%;
            height: 27%;
            border: 1px solid #00cdfe;
        }*/

        #ec04_bar,
        #ec05_bar,
        #ec06_bar,
        #ec07_bar,
        #ec08_bar,
        #ec09_bar,
        #ec10_bar,
        #ec11_bar,
        #ec12_bar,
        #ec13_bar {
            visibility: hidden;
            position: relative;
        }

        #ec04_bar_img,
        #ec05_bar_img,
        #ec06_bar_img,
        #ec07_bar_img,
        #ec08_bar_img,
        #ec09_bar_img,
        #ec10_bar_img,
        #ec11_bar_img,
        #ec12_bar_img,
        #ec13_bar_img {
            position: absolute;
            top: 20%;
        }
        .nav_btns .pt_btn.home_btn {
            background-image: url("${ctx}/690/images/home_on.png");
        }
        .p_on .rise_ico {
            width: 1.5rem;
            height: 1rem;
            border-radius: 0;
            background-size: 100%;
        }

        /* .p_on span {
            display: block;
        } */
        .pointer {
            width: 100%;
        }

        .turndown {
            top: .7%;
        }

        #ec04_bar_img,
        #ec05_bar_img,
        #ec06_bar_img,
        #ec07_bar_img,
        #ec08_bar_img,
        #ec09_bar_img,
        #ec10_bar_img,
        #ec11_bar_img,
        #ec12_bar_img,
        #ec13_bar_img {
            top: 21%;
        }

        @media (max-width: 1400px) {

            .legend,
            .yhxw-ill {
                top: 510%;
            }
            .yhxw-ill {
                right: 2%;
            }
        }

        @media (max-width: 1400px) and (min-height: 701px) {
            .legend {
                top: 500%;
            }

            .yhxw-ill {
                top: 500%;
            }

            .m_left_top_item:first-child {
                height: 65.8%;
            }

            .m_left_top>.m_left_top_item {
                line-height: 3.5rem;
            }

            .m_left_oth {
                height: 76.9%;
                margin-top: 4%;
            }

            .int span {
                width: auto;
                padding-left: 0.15rem
            }

            #ec04_bar_img,
            #ec05_bar_img,
            #ec06_bar_img,
            #ec07_bar_img,
            #ec08_bar_img,
            #ec09_bar_img,
            #ec10_bar_img,
            #ec11_bar_img,
            #ec12_bar_img,
            #ec13_bar_img {
                margin-top: 0%;
                top: 20%;
            }
        }

        @media (max-height: 700px) {
            .int span {
                width: 9%;
                /* margin-left: -2%; */
            }
        }

        @media screen and (min-height: 801px) and (min-width: 1400px) {
            /* .gat {
                margin-left: 64%;
            } */

            div.addline2 {
                right: -191%;
            }

            .tables {
                height: 87.8%;
            }

            .line_bottom {
                bottom: 4.4%;
            }
            .xAxis_box {
                height: 5.4%;
            }

            .legend {
                top: 500%;
            }

            .yhxw-ill {
                top: 499%;
            }

            .m_left_top>.m_left_top_item {
                line-height: 3.25rem;
            }

            .m_left_oth {
                height: 76.4%;
                margin-top: 4%;
            }

            .turndown {
                top: 1.7%;
            }

            #ec04_bar_img,
            #ec05_bar_img,
            #ec06_bar_img,
            #ec07_bar_img,
            #ec08_bar_img,
            #ec09_bar_img,
            #ec10_bar_img,
            #ec11_bar_img,
            #ec12_bar_img,
            #ec13_bar_img {
                top: 18%;
            }
        }

        @-moz-document url-prefix() {
            @media (min-height: 801px) {
                .m_left_top>.m_left_top_item {
                    line-height: 3.25rem;
                }

                .turnup {
                    height: 90.7%;
                    margin-top: -1.7%;
                }

                .int {
                    margin-top: .6%;
                }

                #ec04_bar_img,
                #ec05_bar_img,
                #ec06_bar_img,
                #ec07_bar_img,
                #ec08_bar_img,
                #ec09_bar_img,
                #ec10_bar_img,
                #ec11_bar_img,
                #ec12_bar_img,
                #ec13_bar_img {
                    top: 19%;
                }

                .m_left_top>.m_left_top_item:first-child {
                    height: 66%;
                }

                .m_left_top>.m_left_top_item {
                    margin-bottom: 1%;
                }
            }

            @media (max-height: 800px) and (min-width: 1400px) {
                .int {
                    margin-top: .7%;
                }

                #ec04_bar_img,
                #ec05_bar_img,
                #ec06_bar_img,
                #ec07_bar_img,
                #ec08_bar_img,
                #ec09_bar_img,
                #ec10_bar_img,
                #ec11_bar_img,
                #ec12_bar_img,
                #ec13_bar_img {
                    top: 21.8%;
                }

                .m_left_top>.m_left_top_item:first-child {
                    height: 66%;
                }

                .m_left_top>.m_left_top_item {
                    margin-bottom: 1.4%;
                }
            }

            @media (max-width: 1400px) and (min-height: 701px) {}

            @media (max-height: 700px) {}
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
    <!-- <div class="arrow arrow_up"></div>
<div class="arrow arrow_right"></div> -->
    <header>
        <h2 class="title">智家定制平台用户小微分类升级显示</h2>
        <div class="time"><span></span>-<span></span>-<span></span>&nbsp;&nbsp;<span></span>:<span></span>:<span></span></div>
    </header>
    <div class="subnav">
        <div class="row1">
            <!-- <div class="pt_btn pt_btn_active" id="yhxw">用户小微</div>
        <div class="pt_btn" id="fhxw">孵化小微</div>
        <div class="pt_btn" id="cdwl">触点网络</div>-->
            <div class="charts_legend">
                <span class="charts_legend_mb"></span>
                目标
                <span class="charts_legend_sj"></span>
                实际
            </div>
            <div class="legend">
                <span class="star five"></span><span>5星</span>
                <span class="star four"></span><span>4星</span>
                <span class="star three"></span><span>3星</span>
                <span class="star two"></span><span>2星</span>
                <span class="star one"></span><span>1星</span>
            </div>
            <div class="yhxw-ill flex_center">横：首位度/收入增幅/利润率 纵：预算保障度/预实零差/增值分享 </div>
        </div>
    </div>
    <main>
        <div class="m_left">
            <div class="m_left_top">
                <span class="m_left_top_item flex_center">引爆目标</span>
                <span class="m_left_top_item flex_center">小微升级</span>
            </div>

            <div class="m_left_oth">
                <div class="addline addline1"></div>
                <div class="addline addline2"></div>
                <!-- <div class="line line1"></div>
            <div class="line line2"></div> -->
                <div class="turnup">
                    <!--<div></div>-->
                    <!-- <img src="${ctx}/690/images/yhxw-y1-first.jpg" alt="" width="100%" height="100%"> -->
                    <p class="left_title">基础<span>2个100%</span></p>
                    <div class="turnbox">
                        <div class="titilebox box_sp">自演进自驱动</div>
                        <div class="boxcnt">
                            星系生态圈自演进</br>
                            用户体验迭代驱动自运转</br>
                            <span>验证 : 生态收入倍数增长</span>
                        </div>
                    </div>
                    <div class="turnbox">
                        <div class="titilebox box_sp">用户付薪驱动</div>
                        <div class="boxcnt">
                            用户最佳体验下的高分享</br>
                            吸更高的人创更高价值</br>
                            <span>验证 : 抢高目标持续高分享</span>
                        </div>
                    </div>
                    <div class="turnbox">
                        <div class="titilebox box_sp">事中按单聚散</div>
                        <div class="boxcnt">
                            高低两端动态优化</br>
                            开放的后备人才池</br>
                            <span>验证 : 到天预实零差</span>
                        </div>
                    </div>
                    <div class="turnbox">
                        <div class="titilebox box_sp">事前竞单上岗</div>
                        <div class="boxcnt boxcnt_small">
                            全流程同一目标跟投对赌</br>
                            创用户价值增值分享</br>
                            <span>验证 : 全流程预案>1.2目标</span>
                            <span class="wraptxt">预赢的超利额</span>
                        </div>
                    </div>
                    <div class="turnbox">
                        <div class="titilebox box_sp">引爆引领目标驱动</div>
                        <div class="boxcnt boxcnt_small">
                            引爆目标（日/月/季/920）</br>
                            目标引领（三高/三生）</br>
                            <span>验证 : 三生类-独角兽目标</span>
                            <span class="wraptxt">三高类-行业引领</span>
                        </div>
                    </div>
                    <!-- <img src="images/yhxw-y1-first.jpg" height="100%" width="100%"/> -->
                </div>
                <div class="turndown">
                    <div class="turnbox_s flex_center">
                        两个零(0代工，0代理)
                    </div>
                </div>
            </div>
        </div>
        <div class="m_right">
            <div class="column column_1">
                <div class="column_top">
                    <h2 class="title1" data-xwcode="111111">智家定制平台</h2>
                    <div class="int charts" id="ec00_bar"></div>
                    <div class="int pinglun0">
                    </div>
                </div>
                <div class="column_oth">
                    <div class="oth_up">
                        <div class="little_title">
                            <div class="gat">升级目标(数量/占比)</div>
                        </div>
                        <div class="tables lunci1 area_1">

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

                    </div>

                </div>
            </div>

            <!-- 滚动区域 -->
            <div class="m_right_scroll">
                <div class="btn_next">&gt;</div>
                <div class="screen">
                    <div class="scroll">
                        <div class="column column_2">
                            <div class="column_top">
                                <h2 class="title2 tit" data-incode="BAA">制冷 - </h2>
                                <div class="int charts" id="ec04_bar"></div>
                                <div class="int charts" id="ec04_bar_img"></div>
                                <div class="int pinglun1">
                                </div>
                            </div>
                            <div class="column_oth">
                                <div class="oth_up">
                                    <div class="little_title">
                                        <!--  <div class="gat">目标/实际</div>-->
                                    </div>
                                    <div class="tables lunci2 area_2">
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
                                </div>
                            </div>
                        </div>
                        <div class="column column_3">
                            <div class="column_top">
                                <h2 class="title3 tit" data-incode="ABA">洗涤 - </h2>
                                <div class="int charts" id="ec05_bar"></div>
                                <div class="int charts" id="ec05_bar_img"></div>
                                <div class="int pinglun2">
                                </div>
                            </div>
                            <div class="column_oth">
                                <div class="oth_up">
                                    <div class="little_title">
                                        <!-- <div class="gat">目标/实际</div>-->
                                    </div>
                                    <div class="tables lunci3 area_3">
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
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="scroll">
                        <div class="column column_2">
                            <div class="column_top">
                                <h2 class="title4 tit" data-incode="BCB">空气圈 - </h2>
                                <div class="int charts" id="ec06_bar"></div>
                                <div class="int charts" id="ec06_bar_img"></div>
                                <div class="int pinglun3">
                                </div>
                            </div>
                            <div class="column_oth">
                                <div class="oth_up">
                                    <div class="little_title">
                                        <!--<div class="gat">目标/实际</div>-->
                                    </div>
                                    <div class="tables lunci4 area_4">
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
                                </div>
                            </div>
                        </div>
                        <div class="column column_3">
                            <div class="column_top">
                                <h2 class="title5 tit" data-incode="FAB">热水器 - </h2>
                                <div class="int charts" id="ec07_bar"></div>
                                <div class="int charts" id="ec07_bar_img"></div>
                                <div class="int pinglun4">
                                </div>
                            </div>
                            <div class="column_oth">
                                <div class="oth_up">
                                    <div class="little_title">
                                        <!--<div class="gat">目标/实际</div>-->
                                    </div>
                                    <div class="tables lunci5 area_5">
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
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="scroll">
                        <div class="column column_2">
                            <div class="column_top">
                                <h2 class="title6 tit" data-incode="BCD">厨电 - </h2>
                                <div class="int charts" id="ec08_bar"></div>
                                <div class="int charts" id="ec08_bar_img"></div>
                                <div class="int pinglun5">
                                </div>
                            </div>
                            <div class="column_oth">
                                <div class="oth_up">
                                    <div class="little_title">
                                        <!--<div class="gat">目标/实际</div>-->
                                    </div>
                                    <div class="tables lunci4 area_6">
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
                                </div>
                            </div>
                        </div>
                        <div class="column column_2">
                            <div class="column_top">
                                <h2 class="title7 tit" data-incode="BAA">制冷 - </h2>
                                <div class="int charts" id="ec09_bar"></div>
                                <div class="int charts" id="ec09_bar_img"></div>
                                <div class="int pinglun1">
                                </div>
                            </div>
                            <div class="column_oth">
                                <div class="oth_up">
                                    <div class="little_title">
                                        <!--<div class="gat">目标/实际</div>-->
                                    </div>
                                    <div class="tables lunci4 area_7">
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
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="scroll">
                        <div class="column column_2">
                            <div class="column_top">
                                <h2 class="title8 tit" data-incode="ABA">洗涤 - </h2>
                                <div class="int charts" id="ec10_bar"></div>
                                <div class="int charts" id="ec10_bar_img"></div>
                                <div class="int pinglun2">
                                </div>
                            </div>
                            <div class="column_oth">
                                <div class="oth_up">
                                    <div class="little_title">
                                        <!--<div class="gat">目标/实际</div>-->
                                    </div>
                                    <div class="tables lunci4 area_8">
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
                                </div>
                            </div>
                        </div>
                        <div class="column column_2">
                            <div class="column_top">
                                <h2 class="title9 tit" data-incode="BCB">空气圈 - </h2>
                                <div class="int charts" id="ec11_bar"></div>
                                <div class="int charts" id="ec11_bar_img"></div>
                                <div class="int pinglun3">
                                </div>
                            </div>
                            <div class="column_oth">
                                <div class="oth_up">
                                    <div class="little_title">
                                        <!--<div class="gat">目标/实际</div>-->
                                    </div>
                                    <div class="tables lunci4 area_9">
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
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="scroll">
                        <div class="column column_2">
                            <div class="column_top">
                                <h2 class="title10 tit" data-incode="FAB">热水器 - </h2>
                                <div class="int charts" id="ec12_bar"></div>
                                <div class="int charts" id="ec12_bar_img"></div>
                                <div class="int pinglun4">
                                </div>
                            </div>
                            <div class="column_oth">
                                <div class="oth_up">
                                    <div class="little_title">
                                        <!--<div class="gat">目标/实际</div>-->
                                    </div>
                                    <div class="tables lunci4 area_10">
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
                                </div>
                            </div>
                        </div>
                        <div class="column column_2">
                            <div class="column_top">
                                <h2 class="title11 tit" data-incode="BCD">厨电 - </h2>
                                <div class="int charts" id="ec13_bar"></div>
                                <div class="int charts" id="ec13_bar_img"></div>
                                <div class="int pinglun5">
                                </div>
                            </div>
                            <div class="column_oth">
                                <div class="oth_up">
                                    <div class="little_title">
                                        <!--<div class="gat">目标/实际</div>-->
                                    </div>
                                    <div class="tables lunci4 area_11">
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
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--X 轴-->
            <div class="xAxis_box">
                <div class="xAxis_numbs">
                    <span><span class="point_line"></span>高于<br>行业</span>
                    <span><span class="point_line"></span>预实<br>零差</span>
                    <span><span class="point_line"></span>套圈<br></span>
                    <span><span class="point_line"></span>套圈<br>引领</span>
                    <span><span class="point_line"></span>换道<br>引领</span>
                </div>
                <div class="xAxis_numbs">
                    <span><span class="point_line"></span>高于<br>行业</span>
                    <span><span class="point_line"></span>预实<br>零差</span>
                    <span><span class="point_line"></span>套圈</span>
                    <span><span class="point_line"></span>套圈<br>引领</span>
                    <span><span class="point_line"></span>换道<br>引领</span>
                </div>
                <div class="xAxis_numbs">
                </div>
            </div>


    </main>
    <div class="line_bottom"></div>
    <div class="addxname">目标</div>
    <div class="alertbox">

    </div>

    <!-- <div class="submitbox box_sp flex_center">
    <div id="reset" class="flex_center">编辑</div>
    <div id="submit" class="flex_center">提交</div>
    <div class="submitbox_btn flex_center">◀</div>
</div> -->

    
    <script src="${ctx}/690/js/echarts-4.2.0.js"></script>
    <script src="${ctx}/690/js/common.js"></script>
    <script src="${ctx}/690/js/UEcommon.js"></script>
    <script src="${ctx}/690/js/URLcomn.js"></script>
    <script src="${ctx}/690/js/chartsCom.js"></script>
    <script src="${ctx}/690/js/topNav.js"></script>
    <script src="${ctx}/690/js/sy_yhxv.js"></script>
</body>
<script>
    $(function () {
        /* 平台切换*/

        // $(".pt_btn ").click(function () {
        //     $(this).addClass("pt_btn_active").siblings(".pt_btn ").removeClass("pt_btn_active");
        //     $('.submitbox').css('width', '0');   //隐藏提交按钮
        //     let btn_id = $(this).attr("id");
        //     switch (btn_id) {
        //         case "yhxw":
        //             alert(1111);
        //             break;
        //         case "fhxw":
        //             alert(222);
        //             break;
        //         case "cdwl":
        //             alert(333);
        //             break;

        //     }
        // });


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