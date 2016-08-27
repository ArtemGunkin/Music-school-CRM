<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Music School CRM</title>
    <link href="../../assets/css/theme.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">Music School</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse ">
                <ul class="nav navbar-nav">
                    <li><a href="/news">News</a></li>
                    <li><a href="/about">About</a></li>
                    <li><a href="/schools">Schools</a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                <@security.authorize ifAnyGranted="ROLE_ADMIN">
                    <li><a href="/admin">Dashboard</a></li>
                    <li><a href="/admin/users">Clients</a></li>
                    <li><a href="/admin/schools">Schools</a></li>
                    <li><a href="/admin/workers">Workers</a></li>
                    <li><a href="/logout">Logout</a></li>
                </@security.authorize>
                <@security.authorize ifAnyGranted="ROLE_MANAGER">
                    <li><a href="/admin/content">Content</a></li>
                    <li><a href="/logout">Logout</a></li>
                </@security.authorize>
                <@security.authorize ifAnyGranted="ROLE_USER">
                    <li><a href="/user">Profile</a></li>
                    <li><a href="/logout">Logout</a></li>
                </@security.authorize>
                </ul>
            </div>
        </div>
    </div>
</div>
