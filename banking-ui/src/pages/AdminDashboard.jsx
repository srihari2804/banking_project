import { Link, useNavigate } from "react-router-dom";

function AdminDashboard() {

    const navigate = useNavigate();

    function logout() {
        localStorage.clear();
        navigate("/");
    }

    return (
        <div>
            <nav className="navbar navbar-dark bg-dark px-4">
                <span className="navbar-brand">🏦 Hari Bank - Admin</span>
                <button className="btn btn-light" onClick={logout}>Logout</button>
            </nav>

            <div className="container mt-4">
                <h2>Bank Employee Dashboard</h2>
                <p className="text-muted">Administration Panel</p>

                <div className="row g-3 mt-3">
                    <div className="col-md-4">
                        <div className="card shadow-sm">
                            <div className="card-body">
                                <h5>Users</h5>
                                <p>View all registered users and manage roles.</p>
                                <Link className="btn btn-primary" to="/admin/users">View Users</Link>
                            </div>
                        </div>
                    </div>

                    <div className="col-md-4">
                        <div className="card shadow-sm">
                            <div className="card-body">
                                <h5>Customers</h5>
                                <p>View customer details from the banking system.</p>
                                <Link className="btn btn-primary" to="/admin/customers">View Customers</Link>
                            </div>
                        </div>
                    </div>

                    <div className="col-md-4">
                        <div className="card shadow-sm">
                            <div className="card-body">
                                <h5>Employee Access</h5>
                                <p>Promote a normal user to an admin when required.</p>
                                <Link className="btn btn-primary" to="/admin/users">Manage Access</Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default AdminDashboard;
