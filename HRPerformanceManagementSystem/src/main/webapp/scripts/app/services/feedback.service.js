'use strict';

app
    .factory('Feedback', function ($resource, $filter) {
        return $resource('/resources/feedbacks/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'encadrant' : { 
                        method: 'GET',
                        isArray: true,
                        url: '/resources/feedbacks/encadrant/:id'
                      },
            'collaborateur' : { 
                        method: 'GET',
                        isArray: true,
                        url: '/resources/feedbacks/collaborateur/:id'
                      },
            
            'qualificationglobale' : { 
                        method: 'GET',
                        isArray: false,
                        url: '/resources/feedbacks/qualificationglobale/:id'
                      },
            'bap' : { 
                        method: 'GET',
                        isArray: true,
                        url: '/resources/feedbacks/bap/:id'
                      },
            'update': { method:'PUT' },
            
            'save': { method:'POST' }
        });
    });
