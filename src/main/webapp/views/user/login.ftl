<#include "../templates/header.ftl">

<div class="container col-lg-4 col-lg-offset-4">
    <form class="form-signin" action="j_spring_security_check" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <#if msg?has_content>
            <h5 class="danger">${msg}</h5>
        </#if>
        <hr>
        <div class="form-group">
            <label for="login">Login:</label>
            <input type="text" class="form-control" id="login" name="j_username" required autofocus>
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" name="j_password" required>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" name="remember_me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

</div>
