<#include "../templates/header.ftl">
<div class="container">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">About Us
                <small>It's Nice to Meet You!</small>
            </h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sint, explicabo dolores ipsam aliquam inventore corrupti eveniet quisquam quod totam laudantium repudiandae obcaecati ea consectetur debitis velit facere nisi expedita vel?</p>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">Our Team</h2>
        </div>

        <#if workers? has_content>
        <#list workers as worker>
        <div class="col-lg-4 col-sm-6 ">
            <img class="img-circle img-responsive" src="/assets/images/profile.png" alt="">
            <h3>${worker.fullName()}
                <small>${worker.getJobTitle()}</small>
            </h3>
            <p>${worker.getInfo()}</p>
        </div>
        </#list>
        </#if>
    </div>

    <hr>

    <#include "../templates/footer.ftl">
</div>