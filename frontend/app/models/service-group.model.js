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

        function get() {
cd
        }

        function getAll() {
            return $resource(`${apiPath.root}/category/all`).query();
        }

        function save(newGroup, file) {
            let formData = new FormData();
            if (file) {
                formData.append('avatar', file);
            }
            formData.append('name', newGroup.name);
            formData.append('avatarPath', newGroup.avatarPath);
            PostFile.setUrl(`${apiPath.root}/category/add`);
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