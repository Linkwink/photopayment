/**
 * Created by dn110592kvo on 21.07.2017.
 */
;(function () {
    'use strict';

    angular.module('app').factory('serviceGroup', serviceGroup);

    serviceGroup.$inject = ['$resource', 'apiPath'];

    function serviceGroup($resource, apiPath) {
        let root = `${apiPath.root}/service-group`;

        return $resource(root, {}, {
            save: {
                method: 'POST',
                url: `${root}/add`,
                headers: {'Content-Type': undefined},
                transformRequest: (data) => {
                    let transformed = new FormData();
                    transformed.append('serviceGroup', JSON.stringify({id: null, name: data.name}));
                    transformed.append('avatar', data.file.shift().lfFile);
                    return transformed;
                }
            },
            get: {method: 'GET', url: `${root}/:id`, params: {id: '@id'}},
            getFieldTypes: {method: 'GET', url: `${root}/types/all`, isArray: true},
            getAll: {method: 'GET', url: `${root}/all`, isArray: true}
        });
    }

})();