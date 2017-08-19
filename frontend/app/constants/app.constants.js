/**
 * Created by dn110592kvo on 21.07.2017.
 */
;(function () {

    'use strict';

    const appInfo = {
        name: 'Фотоплатеж',
        version: '1.0.0'
    };

    const apiPath = {
      root : 'http://localhost:8080'
    };

    const role = {
        admin: 'ADMIN',
        guest: 'GUEST',
        moderetor: 'MODERATOR',
        accountant: 'ACCOUNTANT',
        manager: 'MANAGER'

    };

    const httpStatusCode = {
        unauthorized : 401
    };

    const tableSettings = {

    };

    angular.module('app')
        .constant('appInfo', appInfo)
        .constant('apiPath', apiPath)
        .constant('role', role)
        .constant('http_sc', httpStatusCode);
})();