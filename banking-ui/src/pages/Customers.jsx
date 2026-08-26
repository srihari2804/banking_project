import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import api from "../api";

function Customers() {

    const navigate = useNavigate();
    const [customers, setCustomers] = useState([]);
    const [search, setSearch] = useState("");

    useEffect(() => {
        api.get("/api/customers")
            .then(response => setCustomers(response.data))
            .catch(error => {
                console.log(error);
                if (error.response?.status === 401 || error.response?.status === 403) {
                    localStorage.clear();
                    navigate("/");
                }
            });
    }, []);

    function logout() {
        localStorage.clear();
        navigate("/");
    }

    const filteredCustomers = customers.filter(customer =>
        (customer.firstName || "").toLowerCase().includes(search.toLowerCase()) ||
        (customer.lastName || "").toLowerCase().includes(search.toLowerCase()) ||
        (customer.customerNumber || "").toLowerCase().includes(search.toLowerCase())
    );

    return (
        <div>
            <nav className="navbar navbar-dark bg-dark px-4">
                <Link className="navbar-brand" to="/admin/dashboard">🏦 Hari Bank - Admin</Link>
                <button className="btn btn-light" onClick={logout}>Logout</button>
            </nav>

            <div className="container mt-4">
                <div className="d-flex justify-content-between align-items-center mb-3">
                    <h2>Customers</h2>
                    <input type="text" className="form-control" style={{width: "280px"}} placeholder="Search customer" value={search} onChange={(e) => setSearch(e.target.value)} />
                </div>

                <div className="table-responsive">
                    <table className="table table-bordered table-hover">
                        <thead className="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>Customer Number</th>
                                <th>Name</th>
                                <th>Username</th>
                                <th>Phone</th>
                                <th>Address</th>
                            </tr>
                        </thead>
                        <tbody>
                            {filteredCustomers.map(customer => (
                                <tr key={customer.id}>
                                    <td>{customer.id}</td>
                                    <td>{customer.customerNumber}</td>
                                    <td>{customer.firstName} {customer.lastName}</td>
                                    <td>{customer.username}</td>
                                    <td>{customer.phone}</td>
                                    <td>{customer.address}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default Customers;
