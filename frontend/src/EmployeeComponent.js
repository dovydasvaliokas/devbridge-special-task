import React, {useState, useEffect} from 'react'
import EmployeeService from './EmployeeService';

function EmployeeComponent() {
    const [employees, setEmployees] = useState([])

    useEffect(() => {
        getEmployees();
    }, [])

    const getEmployees = () => {
        EmployeeService.getEmployees().then((response) => {
            setEmployees(response.data);
            console.log(response.data);
        });
    }

    return (
        <div className = "container">
            <h1 className = "text-center"> Employees List</h1>
            <table className = "table table-striped">
                <thead>
                    <tr>
                        <th> Employee Id</th>
                        <th> Employee Full name</th>
                        <th> Employee Email</th>
                        <th> Employee Phone </th>
                    </tr>
                </thead>
                <tbody>
                    {
                        employees.map(
                                employee =>
                                <tr key = {employee.id}>
                                    <td> {employee.id }</td>
                                    <td> {employee.fullName }</td>
                                    <td> {employee.email }</td>
                                    <td> {employee.phone} </td>
                                </tr>

                        )
                    }

                </tbody>


            </table>

        </div>
    )
}

export default EmployeeComponent