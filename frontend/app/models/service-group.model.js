/**
 * Created by dn110592kvo on 08.08.2017.
 */
/**
 * Created by dn110592kvo on 21.07.2017.
 */
;(function () {
    'use strict';

    angular.module('app').factory('serviceGroupModel', serviceGroupModel);

    serviceGroupModel.$inject = ['$resource', 'PostFile', 'apiPath'];

    function serviceGroupModel($resource, apiPath) {


        function create() {
            return {
                id : null,
                name: null
            }
        }

        function get() {

        }

        function getAll() {
            return $resource(`${apiPath.root}/category/all`).query();
        }

        function save(newGroup, file) {
            let formData = new FormData();
            if (file) {
                formData.append("avatar", file);
            }
            PostFile.setUrl(`${apiPath.root}/category/add`);
            return PostFile.withFile().send(newGroup, formData);
        }

        return {
            create: create,
            get: get,
            getAll: getAll,
            save: save
        }
    }

})();