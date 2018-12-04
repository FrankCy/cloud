<#include "../../indexDep.ftl">
<@html title="" lang="zh-CN">
	<head>
        <meta charset="utf-8">
        <title>用户列表</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="/admin/layui/css/layui.css" media="all" />
        <link rel="stylesheet" href="//at.alicdn.com/t/font_tnyc012u2rlwstt9.css" media="all" />
    </head>
	<body class="childrenBody">
        <div class="layui-form news_list">
            <table class="layui-table">
                <colgroup>
                    <col width="8%">
                    <col width="23%">
                    <col width="23%">
                    <col width="23%">
                    <col width="23%">
                </colgroup>
                <thead>
                <tr>
                    <th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
                    <th>用户名</th>
                    <th>邮箱</th>
                    <th>昵称</th>
                    <th>创建时间</th>
                </tr>
                </thead>
                <tbody class="user_content"></tbody>
            </table>
        </div>
    <div id="page"></div>
    <script type="text/javascript" src="/admin/layui/layui.js"></script>
    <script type="text/javascript" src="/admin/js/user/userList.js"></script>
    </body>
</@html>