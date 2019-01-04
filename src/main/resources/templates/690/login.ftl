<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${ctx}/690/css/reset.css">
    <link rel="stylesheet" href="${ctx}/690/css/common.css">
    <link rel="stylesheet" href="${ctx}/690/css/login.css">
    <link rel="icon" type="image/x-icon" href="favicon.ico" />
    <title>智家定制平台用户小微分类升级显示</title>
</head>

<body>
    <div class="main">
        <h2 class="title">智家定制平台用户小微分类升级显示</h2>
        <div class="login">
            <div class="login_title">用户登录</div>
            <div class="input_box">
                <span class="user_icon"></span>
                <input id="username" type="text" placeholder="请输入你的账户">
            </div>
            <div class="input_box">
                <span class="password_icon"></span>
                <input id="password" type="password" placeholder="请输入你的密码">
            </div>
            <div class="check_box">
                <label class="check" for="remeber"></label>
                <input id="remeber" type="checkbox" >
                <span>记录登录状态</span>
            </div>
            <div class="input_box btn" id="submit">登录</div>
        </div>
    </div>
    <script src="${ctx}/690/js/jquery-3.3.1.min.js"></script>
    <script src="${ctx}/690/js/echarts-4.2.0.js"></script>
    <script src="${ctx}/690/js/login.js"></script>
</body>

</html>