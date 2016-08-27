<#include "../templates/header.ftl">
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h1>${school.getName()}</h1>
        </div>
        <div class="panel-body">
            <p>${school.getInfo()}</p>
            <hr>
            <p>Worker: <strong>${school.getWorker()}</strong></p>
            <p>Cost: <strong>$${school.getCost()}</strong></p>
            <@security.authorize ifAnyGranted="ROLE_USER">
            <form action="${school.getId()}/buy" method="post">
                <button type="submit" class="btn btn-success">Start studying</button>
            </form>
            </@security.authorize>
        </div>
    </div>
    <#include "../templates/footer.ftl">
</div>