import { Link } from "react-router-dom";

function UserDashboard() {

    return (
        <div>

            <nav className="navbar navbar-dark bg-primary px-4">
                <span className="navbar-brand">🏦 Hari Bank</span>
                <Link className="btn btn-light" to="/">Logout</Link>
            </nav>

            <div className="container mt-4">

                <h2>Welcome, Srihari 👋</h2>
                <p className="text-muted">Customer Dashboard</p>

                <div className="row g-3 mt-3">

                    <div className="col-md-4">
                        <div className="card shadow-sm">
                            <div className="card-body">
                                <h6>Available Balance</h6>
                                <h3>₹85,450</h3>
                            </div>
                        </div>
                    </div>

                    <div className="col-md-4">
                        <div className="card shadow-sm">
                            <div className="card-body">
                                <h6>Account Number</h6>
                                <h3>XXXX1234</h3>
                            </div>
                        </div>
                    </div>

                    <div className="col-md-4">
                        <div className="card shadow-sm">
                            <div className="card-body">
                                <h6>Account Status</h6>
                                <h3 className="text-success">ACTIVE</h3>
                            </div>
                        </div>
                    </div>

                </div>

                <div className="mt-4">
                    <h4>Quick Actions</h4>

                    <Link className="btn btn-primary me-2" to="/user/accounts">My Accounts</Link>

                    <Link className="btn btn-primary me-2" to="/user/transactions">Transactions</Link>

                    <Link className="btn btn-secondary" to="/user/profile">My Profile</Link>
                </div>

                <div className="mt-4">
                    <h4>Recent Transactions</h4>

                    <table className="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>Date</th>
                                <th>Description</th>
                                <th>Amount</th>
                                <th>Status</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr>
                                <td>25-08-2026</td>
                                <td>Salary Credit</td>
                                <td className="text-success">+₹35,000</td>
                                <td>SUCCESS</td>
                            </tr>

                            <tr>
                                <td>24-08-2026</td>
                                <td>Electricity Bill</td>
                                <td className="text-danger">-₹2,450</td>
                                <td>SUCCESS</td>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>

        </div>
    );
}

export default UserDashboard;