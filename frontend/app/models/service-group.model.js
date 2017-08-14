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

    function serviceGroupModel($resource, PostFile, apiPath) {


        function create() {
            return {
                id : null,
                name: null,
                avatarPath: null
            }
        }

        function get(id) {
            return $resource(`${apiPath.root}/service-group/${id}`).get();
        }

        function getAll() {
            return $resource(`${apiPath.root}/service-group/all`).query();
        }

        function save(newGroup, file) {
            let formData = new FormData();
            if (file) {
                formData.append('avatar', file);
            }
            formData.append('serviceGroup',JSON.stringify(newGroup));
            PostFile.setUrl(`${apiPath.root}/service-group/add`);
            return PostFile.withFile().send({}, formData).$promise;
        }

        return {
            create: create,
            get: get,
            getAll: getAll,
            save: save
        }
    }

})();