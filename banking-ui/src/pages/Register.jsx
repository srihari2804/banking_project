import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function Register() {

    const navigate = useNavigate();

    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");

    function registerUser() {

        if (password !== confirmPassword) {
            alert("Passwords do not match");
            return;
        }

        axios.post("http://localhost:8080/api/auth/register", {
            username: username,
            email: email,
            password: password
        })
            .then(response => {
                alert(response.data);
                navigate("/");
            })
            .catch(error => {
                console.log("STATUS:", error.response?.status);
                console.log("DATA:", error.response?.data);
                console.log("ERROR:", error.message);
                alert("Registration failed");
            });
    }

    return (
        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-5">

                    <div className="card shadow">

                        <div className="card-body">

                            <h3 className="text-center mb-4">🏦 Hari Bank</h3>

                            <h5 className="text-center mb-4">Create Account</h5>

                            <input type="text" className="form-control mb-3" placeholder="Username" value={username} onChange={(e) => setUsername(e.target.value)} />

                            <input type="email" className="form-control mb-3" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} />

                            <input type="password" className="form-control mb-3" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} />

                            <input type="password" className="form-control mb-3" placeholder="Confirm Password" value={confirmPassword} onChange={(e) => setConfirmPassword(e.target.value)} />

                            <button className="btn btn-primary w-100" onClick={registerUser}>Register</button>

                            <div className="text-center mt-3">
                                <button className="btn btn-link" onClick={() => navigate("/")}>Already have an account? Login</button>
                            </div>

                        </div>

                    </div>

                </div>
            </div>
        </div>
    );
}

export default Register;