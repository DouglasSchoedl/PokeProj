import React, { Component } from 'react'
import { Link } from 'react-router-dom'

export default class Signup extends Component {



    render() {
        return (
            <div>
                <center><h1>Signup</h1></center>
                <Link to="/login">
                    <button variant="outlined">
                        Login
                    </button>
                </Link>
            </div>
        )
    }

}