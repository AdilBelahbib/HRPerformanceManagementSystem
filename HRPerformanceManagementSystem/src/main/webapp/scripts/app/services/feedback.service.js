'use strict';

app
    .factory('Feedback', function ($resource, $filter) {
        return $resource('/HRPerformanceManagementSystem/resources/feedbacks/:id', {}, {
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
                        url: '/HRPerformanceManagementSystem/resources/feedbacks/encadrant/:id'
                      },
            'collaborateur' : { 
                        method: 'GET',
                        isArray: true,
                        url: '/HRPerformanceManagementSystem/resources/feedbacks/collaborateur/:id'
                      },
            
            'qualificationglobale' : { 
                        method: 'GET',
                        isArray: false,
                        url: '/HRPerformanceManagementSystem/resources/feedbacks/qualificationglobale/:id'
                      },
            'bap' : { 
                        method: 'GET',
                        isArray: true,
                        url: '/HRPerformanceManagementSystem/resources/feedbacks/bap/:id'
                      },
            'update': { method:'PUT' },
            
            'save': { method:'POST' }
        });
    });
