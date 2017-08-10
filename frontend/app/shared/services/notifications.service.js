/**
 * Created by dn110592kvo on 10.08.2017.
 */
;(function () {

    'use strict';

    angular.module('app').factory('notification', notification);

    notification.$inject = ['$mdToast'];

    function notification($mdToast) {

        function show(text) {
            return $mdToast.show($mdToast.simple().textContent(text).position('top right').hideDelay(4000));
        }

        function hide() {
            return $mdToast.hide();
        }


        return {
            show: show,
            hide: hide
        };
    }

})();