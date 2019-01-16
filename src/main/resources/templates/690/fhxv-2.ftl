<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${ctx}/690/css/reset.css">
    <!-- <link rel="stylesheet" href="${ctx}/690/css/fhxv.css"> -->
    <link rel="stylesheet" href="${ctx}/690/css/fhxv-2.css">
    <script src="${ctx}/690/js/echarts-4.2.0.js"></script>
    <link rel="icon" type="image/x-icon" href="${ctx}/690/images/favicon.ico" />
    <title>小微分类升级驱动体系</title>
    <style>
        #nav_top_btn {
            position: absolute;
            top: 25%;
            left: 2%;
        }

        #nav_top_btn a {
            text-decoration: underline;
            color: #0083b3;
            font-size: 1.125rem;
        }

        #nav_top_btn a:hover {
            color: white;
        }

        .nav_sub {
            position: relative;
        }

        .search {
            position: absolute;
            top: 87%;
            left: 6.5%;
            text-align: center;
            font-size: 1.2rem;
        }

        .maintitle {
            position: relative;
        }

        .jielun {
            position: absolute;
            top: -1rem;
            height: 80%;
            padding: .5rem;
            font-size: 1.25rem;
            color: #e1e1e6;
            border: 1px solid #0083b3;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .jielun1 {
            width: 49%;
            left: 16%;
            text-align: center;
        }

        .jielun2 {
            width: 15%;
            left: 67%;
        }

        .jielun3 {
            width: 15%;
            left: 84%;
        }

        .fake {
            background: url('${ctx}/690/images/fake.jpg') no-repeat;
            background-size: 100% 103.3%;
        }

        .left_top {
            /* background-image: url('${ctx}/690/images/fhxw_y1.jpg'); */
            background-size: 100% 100%;
        }

        .left_top {
            border-right: 1px solid #15346a;
            border-bottom: 1px solid #15346a;
        }

        .ec_box>div {
            height: 94.7%;
        }

        .left_bottom {
            height: 21.8%;
        }

        @media (max-width: 1400px) {
            .ec_box>div {
                height: 94.7%;
            }

            #bottom_line {
                bottom: 17.4%;
            }
        }

        @media (min-width: 1360px) {
            .right_top {
                height: 88%;
            }

            .left_top {
                height: 78.2%;
            }
        }

        @media (min-width: 1910px) {
            .right_top {
                height: 88%;
            }

            .left_top {
                height: 78%;
            }
        }
    </style>

</head>

<body>

    <div class="container">
        <nav>
            <div class="nav_top">
                <div class="btn_grounp">
                    <div class="pt_btn" id="back_btn">返回</div>
                </div>
                <h2 class="title" id="fhxv_title"><span id="title_name"></span>与行业的对标</h2>
                <!-- <div class="time"><span></span>-<span></span>-<span></span>&nbsp;&nbsp;<span></span>:<span></span>:<span></span></div> -->
            </div>
            <div class="nav_sub">
                <!-- <div class="pt_btn" id="nav_top_btn"><a href="http://10.138.225.204:8080/bi/?proc=1&action=viewer&db=!5171!!8d62!!589e!!503c!!2f!!5171!!8d62!!589e!!503c!&组织=游戏&isConsole=false&au_act=login&adminv=01070403&passv=haier,201812" target="_blank">共赢增值表</a></div> -->
                <div class="search">
                    <span>行业排名</span>
                    <p>无排名</p>
                    <!-- <input type="text" id="search_input"> -->
                    <!-- <span class="save box_sp">保存</span> -->
                </div>
                <div class="legend">
                    <div class="show show_1">
                        <div class="ball ball_1"></div>
                        <span id="mb"><span></span>目标</span>
                    </div>
                    <div class="show show_2">
                        <div class="ball ball_2"></div>
                        <span id="sj"><span></span>实际</span>
                    </div>
                    <div class="show show_3">
                        <div class="ball ball_3"></div>
                        <span id="ds"></span>
                    </div>
                </div>
                <div class="company_time">
                    成立时间: &nbsp;&nbsp;<span id="xw_name"></span><span id="xw_create_time"></span>
                    <span id="ds_name" style="padding-left: 10px;"></span><span id="ds_create_time"></span>
                </div>
            </div>
        </nav>
        <div class="maintitle">
            <div class="jielun jielun1">
            </div>
            <div class="jielun jielun2">
            </div>
            <div class="jielun jielun3">
            </div>
            <div class="titlein">
                <div>
                    <h2>融资额</h2>
                    <!-- <p>无独角兽目标</p> -->
                </div>
                <div>
                    <h2>市场估值 <span>(亿)(倍速)</span></h2>
                    <!-- <p>生态品牌引领差</p> -->
                </div>
                <div>
                    <h2>融资速度 <span>(月)</span></h2>
                    <!-- <p>生态收入规模及倍数增长差</p> -->
                </div>
                <div>
                    <h2 id="changeTit">生态收入 <span>(亿)</span></h2>
                    <!-- <p>生态收入规模及倍数增长差</p> -->
                </div>
                <div>
                    <h2>分段跟投</h2>
                    <!-- <p></p> -->
                </div>
            </div>
        </div>
        <div class="main">
            <div class="left left_top">
                <!-- <div class="left_top_1">
                    <p class="left_title">融资轮次</p>
                    <div class="left_line l_lin1">
                        
                        加速期
                     
                    </div>
                    <div class="turnbox">
                        <div class="titlebox box_sp">独角兽</div>
                        <div class="titlecnt">
                            进入独角兽排行榜</br>
                            成为独角兽
                        </div>
                    </div>
                    <div class="turnbox">
                        <div class="titlebox box_sp">C轮</div>
                        <div class="titlecnt">
                            正现金流</br>
                            实现盈利，生态收入倍数增长
                        </div>
                    </div>
                    <div class="turnbox">
                        <div class="titlebox box_sp">B轮</div>
                        <div class="titlecnt">
                            验证商业模式生态吸力</br>
                            收入倍数增长</br>
                            用户及资源方蜂拥而至
                        </div>
                    </div>

                        <div class="left_line l_lin2">
                            A轮及以下
                        </div>
                        <div class="turnbox">
                            <div class="titlebox box_sp">A轮</div>
                            <div class="titlecnt">
                                有增值分享空间</br>
                                盈利模式清晰</br>
                                有用户粘性
                            </div>
                        </div>

                        <div class="turnbox">
                            <div class="titlebox box_sp">天使轮</div>
                            <div class="titlecnt">
                                创业团队，跟投对赌</br>
                                市场机会空间大
                            </div>
                        </div>
                </div> -->
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
            </div>

            <!-- 图表信息 -->
            <div class="right right_top">
                <div class="ec_box">
                    <div id="ec01_line"></div>
                    <div class="fake"></div>
                </div>
                <div class="ec_box">
                    <div id="ec02_scatter"></div>
                </div>
                <div class="ec_box">
                    <div id="ec03_bar"></div>
                </div>
                <div class="ec_box">
                    <div id="ec04_bar"></div>
                    <div class="wtf">
                        <div id="pie_1"></div>
                        <div id="pie_2"></div>
                    </div>
                </div>
                <div class="ec_box">
                    <div id="ec05_bar">
                        <div class="FDGT" id="djs"></div>
                        <div class="FDGT" id="cl"></div>
                        <div class="FDGT" id="bl"></div>
                        <div class="FDGT" id="al"></div>
                        <div class="FDGT" id="tsl"></div>
                        <div class="FDGT" id="xmc"></div>
                    </div>
                </div>
                <div id="bottom_line"></div>
            </div>
            <!-- $$$$ -->

            <div class="left left_bottom">
                <!-- <div></div> -->
                <!-- <div class="left_bottom_1">
                    <div class="left_line l_lin3">
                        孵化期
                    </div>
                    <div class="turnbox turnbox_spa">
                        <div class="titlebox box_sp turnbox_lb">未引入社会化资本</div>
                        <div class="titlecnt">
                            成立一年以上</br></br>
                            成立半年以上
                        </div>
                    </div>
                </div>
                <div class="left_bottom_2">
                    <div class="left_line l_lin4">
                        新冒出
                    </div>
                    <div class="turnbox turnbox_cut">
                        <div class="titlecnt">
                            成立半年以内
                        </div>
                    </div>
                </div> -->
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
    </div>

    <script src="${ctx}/690/js/jquery-3.3.1.min.js"></script>
    <script src="${ctx}/690/js/URLcomn.js"></script>
    <script src="${ctx}/690/js/fhxv-2.js"></script>
    <script src="${ctx}/690/js/chartsCom.js"></script>
    <script src="${ctx}/690/js/smallMicroDetail.js"></script>

</body>

</html>