<#import "/spring.ftl" as spring>
<#include "../templates/header.ftl">

<div class="container col-lg-4 col-lg-offset-4">
    <form action="/registration" method="post" modelAttribute="userForm">
        <h2 class="form-signin-heading">Please sign up</h2>
        <#--<#if spring.status.error>-->
            <#--<ul>-->
                <#--<#list spring.status.errors.globalErrors as error>-->
                    <#--<li>${error.defaultMessage}</li>-->
                <#--</#list>-->
            <#--</ul>-->
        <#--</#if>-->
        <div class="form-group">
            <label for="login">Login:</label>
            <input type="text" class="form-control" id="login" name="login" required autofocus>
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" name="password" required>
        </div>
        <div class="form-group">
            <label for="first_name">First name:</label>
            <input type="text" class="form-control" id="first_name" name="firstName" required>
        </div>
        <div class="form-group">
            <label for="last_name">Last name:</label>
            <input type="text" class="form-control" id="last_name" name="lastName" required>
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="number" class="form-control" id="phone" name="phone" required>
        </div>
        <div class="form-group">
            <label for="info">Info:</label>
            <textarea class="form-control" id="info" name="info"></textarea>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
    </form>

    <br>
    <#include "../templates/footer.ftl">
</div>