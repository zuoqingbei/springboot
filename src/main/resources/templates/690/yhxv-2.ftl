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
            margin-top: .8rem;
            text-align: center;
 	        font-family: "微软雅黑";
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
            margin-top: 3%;
            padding: 5px 0;
            font-size: .95rem;
            line-height: 1.125rem;
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
            width: 98.8%;
            height: 5.5%;
            margin: 0;
            padding-left: 13.5%;
        }

        .inputs_box>div:first-of-type,
        .inputs_box>div:last-of-type {
            flex: 0 0 28.5%;
        }

        .inputs_box>div {
            flex: 0 0 42%;
        }

        .table_box {
            margin-bottom: .5%;
        }

        .table_box {
            height: 37.5%;
        }

        .star_box span {
            color: #fff;
        }

        @media (max-width:1400px) and (max-height:750px) {
            .yaxis_name {
                margin-top: -15px;
            }
            
            .inputs_box {
                height: 6%;
            }
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
                <!--  <span class="star_box_name">升级目标</span><span>12月：</span><span id="t1"></span><span>2019年1月：</span><span id="t2"></span>
              <span>2月：</span><span id="t3"></span><span>3月：</span><span id="t4"></span><span>4月：</span><span id="t5"></span><span>5月：</span><span id="t6"></span>-->
            </div>
            <!-- <div class="submitbox box_sp flex_center">
             <div id="edit" class="flex_center reset">编辑</div>
             <div id="submit" class="flex_center">提交</div>
             <div class="submitbox_btn flex_center">◀</div>
         </div>-->
            <!--  <div class="submit">
              提交
          </div>-->
        </div>
        <div class="main_content">
            <div class="content_left">
                <div class="content_left_name" id="tit"></div>
                <div class="content_left_table">
                    <ul>
                        <li>纵横匹配</li>
                        <li>目标</li>
                        <li>承接</li>
                        <li>差</li>
                    </ul>
                    <ul class="axis">纵轴</ul>
                    <ul>
                        <li>1.首位度</li>
                        <li>2.0</li>
                        <li>2</li>
                        <li>3</li>
                    </ul>
                    <ul>
                        <li>2.收入增幅</li>
                        <li>2.0</li>
                        <li>2</li>
                        <li>3</li>
                    </ul>
                    <ul>
                        <li>3.利润率</li>
                        <li>2.0</li>
                        <li>2</li>
                        <li>3</li>
                    </ul>
                    <ul class="axis">横轴</ul>
                    <ul>
                        <li>1.预案保障度</li>
                        <li>120%</li>
                        <li>2</li>
                        <li>3</li>
                    </ul>
                    <ul>
                        <li> -并联节点</li>
                        <li>2.0</li>
                        <li>2</li>
                        <li>3</li>
                    </ul>
                    <ul>
                        <li>2.预实零差</li>
                        <li>100%</li>
                        <li>2</li>
                        <li>3</li>
                    </ul>
                    <ul>
                        <li>3.增值分享</li>
                        <li>2.0</li>
                        <li>2</li>
                        <li>3</li>
                    </ul>
                </div>
            </div>
            <div class="content_right">
                <div class="content_left_name content_right_name">纵横匹配显差</div>
                <div class="axis_name">横轴:目标</div>
                <div class="echarts_box">
                    <div>
                        <div class="content_left_name echarts_name">首位度</div>
                        <div id="ec01_line" style="width: 95%;height: 87%;margin: 0 auto"></div>
                    </div>
                    <div>
                        <div class="content_left_name echarts_name">收入增幅</div>
                        <div id="ec02_line" style="width: 95%;height: 87%;margin: 0 auto"></div>
                    </div>
                    <div>
                        <div class="content_left_name echarts_name">利润率</div>
                        <div id="ec03_line" style="width: 95%;height: 87%;margin: 0 auto"></div>
                    </div>
                </div>
                <div class="axis_name yaxis_name">纵轴:并联体系/用户付薪</div>
                <div class="table_box">
                    <table border="1" cellspacing="0" style="table-layout:fixed;">
                        <tr>
                            <th rowspan="2" colspan="1" class="td_border_bold">并联节点</th>
                            <th rowspan="2" colspan="1">人员</th>
                            <th colspan="2" class="td_border_bold">单</th>
                            <th colspan="4">预案承接预实差</th>
                        </tr>
                        <tr>
                            <th>目标</th>
                            <th class="td_border_bold">实际</th>
                            <th>目标</th>
                            <th>增值分享</th>
                            <th>承接</th>
                            <th class="td_border_bold">承接差</th>
                            <!-- <th>实际</th>
                            <th>差</th> -->
                            <#--  <th>关差预案</th>  -->
                        </tr>
                        <tr id="tr0">
                            <td class="td_border_bold">用户小微</td>
                            <td></td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <!-- <td>-</td>
                            <td>-</td> -->
                            <#--  <td class="gccj">-</td>  -->
                        </tr>
                        <tr id="tr1">
                            <td class="td_border_bold">设计</td>
                            <td></td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <!-- <td>-</td>
                            <td>-</td> -->
                            <#--  <td class="gccj">-</td>  -->
                        </tr>
                        <tr id="tr2">
                            <td class="td_border_bold">模块采购</td>
                            <td></td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <!-- <td>-</td>
                            <td>-</td> -->
                            <#--  <td class="gccj">-</td>  -->
                        </tr>
                        <tr id="tr3">
                            <td class="td_border_bold">销售</td>
                            <td></td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <!-- <td>-</td>
                            <td>-</td> -->
                            <#--  <td class="gccj">-</td>  -->
                        </tr>
                        <tr id="tr4">
                            <td class="td_border_bold">供应链</td>
                            <td></td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <!-- <td>-</td>
                            <td>-</td> -->
                            <#--  <td class="gccj">-</td>  -->
                        </tr>
                        <tr id="tr5">
                            <td class="td_border_bold">服务</td>
                            <td></td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td class="td_border_bold">-</td>
                            <!-- <td>-</td>
                            <td>-</td> -->
                            <#--  <td class="gccj">-</td>  -->
                        </tr>
                    </table>
                </div>
                <div class="inputs_box">
                    <div>
                        <textarea id="txt1" disabled></textarea>
                    </div>
                    <div>
                        <textarea id="txt2" disabled></textarea>
                    </div>
                    <div>
                        <textarea id="txt3" disabled></textarea>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="${ctx}/690/js/jquery-3.3.1.min.js"></script>
<script src="${ctx}/690/js/echarts-4.2.0.js"></script>
<script src="${ctx}/690/js/jquery.raty.min.js"></script>
<script src="${ctx}/690/js/UEcommon.js"></script>
<script src="${ctx}/690/js/URLcomn.js"></script>
<script src="${ctx}/690/js/chartsCom.js"></script>
<script src="${ctx}/690/js/consumer_micro/consumer_second.js"></script>
<script src="${ctx}/690/js/consumer_micro/consumer_second2.js"></script>
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