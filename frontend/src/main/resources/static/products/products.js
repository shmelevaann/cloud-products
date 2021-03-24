angular.module('app').controller('productsController',
    function ($scope, $http) {
      $scope.products = [];
      $scope.product = {};

      $scope.findAllProducts = function () {
        $http({
          url: '/api/v1/products',
          method: 'GET',
          params: {
            page: $scope.page ? $scope.page : 0,
            size: $scope.size ? $scope.size : 3
          }
        })
        .then((response) => {
          $scope.products = response.data.products;
          $scope.page = response.data.currentPage;
          $scope.totalPages = response.data.totalPages;
        })
      }

      $scope.previousPage = function () {
        $scope.page--;
        $scope.findAllProducts();
      }

      $scope.nextPage = function () {
        $scope.page++;
        $scope.findAllProducts();
      }

      $scope.createProduct = function () {
        $http.put('/api/v1/products', $scope.product).then(() => {
          $scope.product = {};
          $scope.findAllProducts();
        });
      }
      $scope.deleteProduct = function (id) {
        $http.delete(`/api/v1/products/${id}`).then(() => {
          $scope.findAllProducts();
        });
      }

      $scope.findAllProducts();
    });
