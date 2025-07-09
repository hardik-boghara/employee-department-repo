const baseUrl = 'http://localhost:8085';
const employeeBaseUrl = baseUrl + '/employee';

export const RouteUrls = {

    UPDATE_EMPLOYEE: employeeBaseUrl + '/add-new-employee',
    GET_EMPLOYEE: employeeBaseUrl,
    GET_EMPLOYEE_BY_DEPT: employeeBaseUrl + '/get-employee',
    DELETE_EMPLOYEE: employeeBaseUrl + '/delete-employee'

}
