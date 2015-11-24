'use strict';

app
    .factory('User', function ($resource, $filter) {
        return $resource('http://localhost:8080/hrpms/resources/users/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'update': { method:'PUT' },
            'bytags': { 
                        method: 'GET',
                        isArray: true,
                        
                        url: 'http://localhost:8080/hrpms/resources/users/tag/:tag'
                      },
            'save': { method:'POST' }
        });
    });
