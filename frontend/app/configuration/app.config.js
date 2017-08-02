/**
 * Created by dn110592kvo on 10.07.2017.
 */
;(function () {

    'use strict';

    angular.module("app").config(configure);

    configure.$inject = ['$httpProvider'];

    function configure($httpProvider) {
        // $httpProvider.interceptors.push('httpAuth');
        //Add to allow uses cookies with CORS
        $httpProvider.defaults.withCredentials = true;
    }
})();