<#include "../templates/header.ftl">

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2>Edit user</h2>
        </div>
        <div class="panel-body">
            <form action="/user/update" method="post" modelAttribute="userForm">
                <div class="form-group">
                    <label for="first_name">First name:</label>
                    <input type="text" class="form-control" id="first_name" name="firstName" value="${user.getFirstName()}" required>
                </div>
                <div class="form-group">
                    <label for="last_name">Last name:</label>
                    <input type="text" class="form-control" id="last_name" name="lastName" value="${user.getLastName()}" required>
                </div>
                <div class="form-group">
                    <label for="phone">Phone:</label>
                    <input type="text" class="form-control" id="phone" name="phone" value="${user.getPhone()!""}" required>
                </div>
                <div class="form-group">
                    <label for="info">Info:</label>
                    <textarea class="form-control" id="info" name="info">${user.getInfo()!""}</textarea>
                </div>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Edit</button>
            </form>
        </div>

    </div>
    <#include "../templates/footer.ftl">
</div>