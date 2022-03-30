<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <h1 style="text-align: center">Поезда на сегодня</h1>
    <div class="row">
        <#list trains as train>
            <div class="col-4">
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">${train.name}</h5>
                        <p class="card-text">${train.description}</p>
                        <a href="/train/${train.id}" class="btn btn-primary">Купить билет</a>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</@c.page>
