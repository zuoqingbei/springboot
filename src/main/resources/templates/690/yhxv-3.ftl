<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${ctx}/690/css/reset.css">
    <link rel="stylesheet" href="${ctx}/690/css/consumer_micro.css">
    <link rel="icon" type="image/x-icon" href="${ctx}/690/images/favicon.ico" />
    <title>小微分类升级驱动体系</title>
    <style>
        .inputs_box>div>textarea {
            font-size: 1rem;
            margin-top: 1.6rem;
            text-align: center;
        }

        .flex_center {
            display: flex;
            align-items: center;
        }

        .btn_grounp {
            position: absolute;
            left: 1%;
            top: 3.5%;
            z-index: 999;
        }

        .btn_grounp .pt_btn {
            padding: 0.3rem 1rem;
            border: 1px solid #0284b5;
            text-align: center;
            vertical-align: middle;
            color: #0284b5;
            margin-right: 2rem;
            cursor: pointer;
            display: inline-block;
        }

        .table_box>table tr th {
            border: 1px solid #153469;
        }

        .table_box td {
            white-space: nowrap;
            overflow: hidden;
            padding: 0 5px;
            border: 1px solid #153469;
        }

        .content_right_name {
            width: 97%;
            margin: 0 auto;
        }

        .axis_name {
            height: auto;
            margin-left: 1.85%;
            margin-top: 1%;
            padding: 5px 0 4px;
            font-size: 1rem;
        }

        .yaxis_name {
            margin-top: 0;
        }

        .content_left_table {
            height: 88%;
        }

        .content_left_table ul.axis {
            padding-top: 2%;
        }

        .inputs_box {
            width: 98%;
            height: 9%;
            margin-top: 1%;
            padding-left: 9.1%;

        }

        .table_box {
            margin-bottom: .5%;
        }

        .table_box {
            height: 41.9%;
        }

        .content_left_charts {
            margin-top: 7%;
            width: 100%;
            height: 88%;
            font-size: 1.125rem;
            color: var(--fontColor);
            position: relative;
        }

        .echarts_box_left {
            width: 100%;
            display: block;
            margin-left: 0;
            height: 100%;
        }

        .echarts_box_left>div {
            height: 28%;
            margin-bottom: 2%;
        }

        .line_chart {
            height: 84%;
        }

        .echarts_box_left>div.jieLun {
            height: 10%;
            margin-bottom: 0;
            line-height: 5rem;
            padding-left: 2%;
        }

        .echarts_box_right {
            height: 28%;
            margin-bottom: 2.65%;
        }

        .alertbox_year {
            position: absolute;
            top: 40%;
            left: 30%;
            width: 44%;
            height: 25%;
            background: #001734;
            box-shadow: 0 0 50px #003b5d inset;
            border: 1px solid #0be8fe;
            border-radius: 8px;
            color: #fff;
            padding: 10px 15px;
            visibility: hidden;
            z-index: 9999;
        }

        .alertbox_jiedian {
            position: absolute;
            top: 40%;
            left: 30%;
            width: 44%;
            height: 25%;
            background: #001734;
            box-shadow: 0 0 50px #003b5d inset;
            border: 1px solid #0be8fe;
            border-radius: 8px;
            color: #fff;
            padding: 10px 15px;
            visibility: hidden;
            z-index: 9999;
        }

        .echarts_name {
            background: 0;
            border: 0;
            box-shadow: 0 0 0;
            padding: .5rem 0 0 0;
            font-size: 1.125rem;
            position: relative;
        }

        .content_left_name .arrow_box {
            width: 2.5rem;
            height: 2rem;
            position: absolute;
            background-size: 50% 50%;
            right: 38%;
        }

        .arrow_up {
            background: url("${ctx}/690/images/up.gif") no-repeat center;
        }

        .arrow_down {
            background: url("${ctx}/690/images/down.gif") no-repeat center;
        }

        .arrow_on {
            background: url("${ctx}/690/images/on.gif") no-repeat center;
        }

        .jieLun span {
            font-size: 1rem;
            line-height: 1.5;
        }

        .jieLun .jieLun_cont {
            color: #fff;
            margin-left: 6px;
        }

        @media screen and (max-height: 768px) and (min-width: 1400px) {
            .table_box {
                height: 41.3%;
                margin-bottom: -.1rem;
            }
        }

        @media (max-width : 1400px) and (max-height: 700px) {
            .echarts_box_right {
                margin-bottom: 1.4%;
            }

            .inputs_box>div {
                height: 98%;
            }

            .axis_name {
                padding: 5px 0 2px;
            }

            .yaxis_name {
                padding: 9px 0 2px;
            }
        }

        @media (max-width : 1400px) and (min-height: 701px) {
            .echarts_box_right {
                margin-bottom: 2.3%;
            }

            .inputs_box>div {
                height: 98%;
            }

            .axis_name {
                padding: 5px 0 2px;
            }

            .yaxis_name {
                padding: 5px 0 2px;
            }
        }

        .yh_jiedian {
            cursor: pointer;
        }

        .charts_legend {
            width: 100%;
            height: 4%;
            position: absolute;
            top: -4%;
            display: flex;
            justify-content: flex-end;
            line-height: 1rem;
            align-items: center;
            font-size: 1rem;
        }

        .charts_legend .charts_legend_line {
            height: 7%;
            width: 3%;
            margin: 0 .5rem;
            background: #0083b3;
            margin-left: 1rem;
        }

        .charts_legend .charts_legend_line.charts_legend_sj {
            background: #fff;
        }

        .charts_legend .text_sj {
            color: #fff;
        }
    </style>


</head>

<body>
    <div class="btn_grounp">
        <div class="pt_btn" id="back_btn">返回</div>
    </div>

    <div class="container">
        <nav>
            <div class="nav_top">
                <h2 class="title"></h2>
                <div class="time"><span></span>-<span></span>-<span></span>&nbsp;&nbsp;<span></span>:<span></span>:<span></span></div>
            </div>
        </nav>
        <div class="star_comment">
            <div class="micro_info">
                <span>小微：</span><span id="XW_NAME">雷神</span><span class="micro_name">小微主：</span><span id="XWZ"></span>
            </div>
            <div class="star_box">
                <span class="star_box_name">星级</span><span>目标：</span><span id="mb_star"></span><span>实际：</span><span id="sj_star"></span>
            </div>
        </div>
        <div class="main_content">
            <div class="content_left">
                <div class="content_left_name">历史业绩</div>
                <div class="content_left_charts">
                    <div class="charts_legend">
                        <span class="charts_legend_line"></span>
                        <span>目标</span>
                        <span class="charts_legend_line charts_legend_sj"></span>
                        <span class="text_sj">实际</span>
                    </div>
                    <div class="echarts_box echarts_box_left">
                        <div>
                            <div class="content_left_name echarts_name">
                                首位度
                                <span class="arrow_box wg_lsze_arrow" id="arrow_box_0"></span>
                            </div>
                            <div class="line_chart" id="ec1_line"></div>
                        </div>
                        <div>
                            <div class="content_left_name echarts_name">
                                收入增幅
                                <span class="arrow_box wg_lsze_arrow" id="arrow_box_1"></span>
                            </div>
                            <div class="line_chart" id="ec2_line"></div>
                        </div>
                        <div>
                            <div class="content_left_name echarts_name">
                                利润率
                                <span class="arrow_box wg_lsze_arrow" id="arrow_box_2"></span>
                            </div>
                            <div class="line_chart" id="ec3_line"></div>
                        </div>
                        <div class="jieLun flex_center">
                            <span>结论：</span>
                            <span class="jieLun_cont"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="content_right">
                <div class="content_left_name content_right_name">纵横匹配显差(当月累计)</div>
                <div class="axis_name">横轴:市场竞争力</div>
                <div class="echarts_box echarts_box_right">
                    <div>
                        <div class="content_left_name echarts_name">首位度</div>
                        <div id="ec01_bar" class="line_chart"></div>
                    </div>
                    <div>
                        <div class="content_left_name echarts_name">收入增幅</div>
                        <div id="ec02_bar" class="line_chart"></div>
                    </div>
                    <div>
                        <div class="content_left_name echarts_name">利润率</div>
                        <div id="ec03_bar" class="line_chart"></div>
                    </div>
                </div>
                <div class="axis_name yaxis_name">纵轴:并联体系/用户付薪</div>
                <div class="table_box">
                    <table border="1" cellspacing="0" style="table-layout:fixed;">
                        <tr>
                            <th rowspan="2" colspan="1" class="td_border_bold">并联节点</th>
                            <th rowspan="2" colspan="1">人员</th>
                            <th colspan="2" class="td_border_bold">单</th>
                            <th colspan="7">预案承接预实差</th>
                        </tr>
                        <tr>
                            <th>目标</th>
                            <th class="td_border_bold">实际</th>
                            <th>目标</th>
                            <th>增值分享</th>
                            <th>承接</th>
                            <th class="td_border_bold">承接差</th>
                            <th>实际</th>
                            <th>差</th>
                            <th>关差预案</th>
                        </tr>
                        <tr id="tr0">
                            <td class="td_border_bold yh_jiedian">用户小微</td>
                            <td class="yh_name"></td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="gccj">-</td>
                        </tr>
                        <tr id="tr1">
                            <td class="td_border_bold yh_jiedian">设计</td>
                            <td class="yh_name"></td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="gccj">-</td>
                        </tr>
                        <tr id="tr2">
                            <td class="td_border_bold yh_jiedian">模块采购</td>
                            <td class="yh_name"></td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="gccj">-</td>
                        </tr>
                        <tr id="tr3">
                            <td class="td_border_bold yh_jiedian">销售</td>
                            <td class="yh_name"></td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="gccj">-</td>
                        </tr>
                        <tr id="tr4">
                            <td class="td_border_bold yh_jiedian">供应链</td>
                            <td class="yh_name"></td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="gccj">-</td>
                        </tr>
                        <tr id="tr5">
                            <td class="td_border_bold yh_jiedian">服务</td>
                            <td class="yh_name"></td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="gccj">-</td>
                        </tr>
                    </table>
                </div>
                <div class="inputs_box">
                    <div>
                        <textarea id="txt1"></textarea>
                    </div>
                    <div>
                        <textarea id="txt2"></textarea>
                    </div>
                    <div>
                        <textarea id="txt3"></textarea>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="alertbox_year">
        <div class="content_left_name echarts_name">用户付薪</div>
        <div id="alertbox" class="line_chart"></div>
    </div>
    <div class="alertbox_jiedian">
        <div class="content_left_name echarts_name">并连节点</div>
        <div id="alertbox" class="line_chart"></div>
    </div>
</body>
<script src="${ctx}/690/js/jquery-3.3.1.min.js"></script>
<script src="${ctx}/690/js/echarts-4.2.0.js"></script>
<script src="${ctx}/690/js/jquery.raty.min.js"></script>
<script src="${ctx}/690/js/UEcommon.js"></script>
<script src="${ctx}/690/js/URLcomn.js"></script>
<script src="${ctx}/690/js/chartsCom.js"></script>
<script src="${ctx}/690/js/yhxw3.js"></script>

<script>
    var mb_star;
    var sj_star;
    var t1_star;
    var t2_star;
    var t3_star;
    var t4_star;
    var t5_star;
    var t6_star;
    $(function () {
        $('#mb_star').raty({
            score: 3,
            path: '${ctx}/690/images',
            starOff: 'star-off.png',
            starOn: 'star-on.png',
            click: function (score) {   //点击时获取星级评分
                console.log(score);
                mb_star = score;
            }
        });
        $('#sj_star').raty({
            score: 3,
            path: '${ctx}/690/images',
            starOff: 'star-off.png',
            starOn: 'star-on.png',
            click: function (score) {
                console.log(score);
                sj_star = score;
            }
        });
        $('#t1').raty({
            score: 3,
            path: '${ctx}/690/images',
            starOff: 'star-off.png',
            starOn: 'star-on.png',
            click: function (score) {
                console.log(score);
                t1_star = score;
            }
        });
        $('#t2').raty({
            score: 3,
            path: '${ctx}/690/images',
            starOff: 'star-off.png',
            starOn: 'star-on.png',
            click: function (score) {
                console.log(score);
                t2_star = score;
            }
        });
        $('#t3').raty({
            score: 3,
            path: '${ctx}/690/images',
            starOff: 'star-off.png',
            starOn: 'star-on.png',
            click: function (score) {
                console.log(score);
                t3_star = score;
            }
        });
        $('#t4').raty({
            score: 3,
            path: '${ctx}/690/images',
            starOff: 'star-off.png',
            starOn: 'star-on.png',
            click: function (score) {
                console.log(score);
                t4_star = score;
            }
        });
        $('#t5').raty({
            score: 3,
            path: '${ctx}/690/images',
            starOff: 'star-off.png',
            starOn: 'star-on.png',
            click: function (score) {
                console.log(score);
                t5_star = score;
            }
        });
        $('#t6').raty({
            score: 3,
            path: '${ctx}/690/images',
            starOff: 'star-off.png',
            starOn: 'star-on.png',
            click: function (score) {
                console.log(score);
                t6_star = score;
            }
        });


    })
</script>

</html>