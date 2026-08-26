import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import api from "../api";

function Users() {

    const navigate = useNavigate();
    const [users, setUsers] = useState([]);
    const [search, setSearch] = useState("");

    useEffect(() => {
        loadUsers();
    }, []);

    function loadUsers() {
        api.get("/api/admin/users")
            .then(response => setUsers(response.data))
            .catch(error => {
                console.log(error);
                if (error.response?.status === 401 || error.response?.status === 403) {
                    localStorage.clear();
                    navigate("/");
                }
            });
    }

    function makeAdmin(id) {
        api.put(`/api/admin/users/${id}/make-admin`)
            .then(response => {
                alert(response.data);
                loadUsers();
            })
            .catch(error => alert(error.response?.data?.message || "Unable to update role"));
    }

    const filteredUsers = users.filter(user =>
        user.username.toLowerCase().includes(search.toLowerCase()) ||
        user.email.toLowerCase().includes(search.toLowerCase())
    );

    function logout() {
        localStorage.clear();
        navigate("/");
    }

    return (
        <div>
            <nav className="navbar navbar-dark bg-dark px-4">
                <Link className="navbar-brand" to="/admin/dashboard">🏦 Hari Bank - Admin</Link>
                <button className="btn btn-light" onClick={logout}>Logout</button>
            </nav>

            <div className="container mt-4">
                <div className="d-flex justify-content-between align-items-center mb-3">
                    <h2>Users</h2>
                    <input type="text" className="form-control" style={{width: "280px"}} placeholder="Search user" value={search} onChange={(e) => setSearch(e.target.value)} />
                </div>

                <div className="table-responsive">
                    <table className="table table-bordered table-hover">
                        <thead className="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>Username</th>
                                <th>Email</th>
                                <th>Role</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {filteredUsers.map(user => (
                                <tr key={user.id}>
                                    <td>{user.id}</td>
                                    <td>{user.username}</td>
                                    <td>{user.email}</td>
                                    <td>{user.role}</td>
                                    <td>{user.status}</td>
                                    <td>
                                        {user.role === "USER" ? (
                                            <button className="btn btn-sm btn-primary" onClick={() => makeAdmin(user.id)}>Make Admin</button>
                                        ) : (
                                            <span className="text-success">Admin</span>
                                        )}
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default Users;
