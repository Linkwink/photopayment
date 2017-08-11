/**
 * Created by dn110592kvo on 26.07.2017.
 */
;(function () {

    'use strict';

    angular
        .module('app')
        .component('appShortcut', {
            templateUrl: 'app/shared/components/shortcut/shortcut.template.html',
            controller: ShortcutController,
        });


    function ShortcutController() {
        let vm = this;

    }

})();
