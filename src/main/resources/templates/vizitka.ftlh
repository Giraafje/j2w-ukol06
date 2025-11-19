[#ftl]
[@c.page]
    <div class="detail">
        <div class="vizitka">
            [@form.form method="post" bind="vizitka" class="d-flex flex-row-reverse bd-highlight"]
                <button type="submit" class="btn btn-outline-danger btn-sm" name="akce" value="smazat">Smazat</button>
            [/@form.form]
            <div class="jmeno">${vizitka.celeJmeno}</div>
            <div class="firma">${vizitka.firma}</div>
            <div class="udaje">
                <div class="adresa">
                    <div>${vizitka.ulice}</div>
                    <div><span>${vizitka.psc}</span> <span>${vizitka.obec}</span></div>
                </div>
                <div class="kontakty">
                    <div><i class="las la-at"></i> <span>[#if vizitka.email??]${vizitka.email}[#else]-[/#if]</span></div>
                    <div><i class="las la-phone-alt"></i> <span>[#if vizitka.telefon??]${vizitka.telefon}[#else]-[/#if]</span></div>
                    <div><i class="las la-globe"></i> <span>[#if vizitka.web??]${vizitka.web}[#else]-[/#if]</span></div>
                </div>
            </div>
        </div>

        <div class="mapa">
            <iframe style="border:none" src="https://frame.mapy.cz/?q=${vizitka.celaAdresa?url}" width="100%" height="100%"
                    frameborder="0"></iframe>
        </div>
        [@c.back /]
    </div>
[/@c.page]
