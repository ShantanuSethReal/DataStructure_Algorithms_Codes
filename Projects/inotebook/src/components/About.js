import React from "react";
import logo from "../Cloud1.png";
import { Link } from "react-router-dom";
const About = () => {
  return (
    <>
      <div className="container my-3">
        <div className="row align-items-center">
          <div className="col-12 col-md-5 col-lg-6 order-md-2">
            <img src={logo} className="img-fluid mw-md-150 mw-lg-130 mb-6 mb-md-0 aos-init aos-animate" alt="..." data-aos="fade-up" data-aos-delay="100" />
          </div>
          <div className="col-12 col-md-7 col-lg-6 order-md-1 aos-init aos-animate" data-aos="fade-up">
            <h1 className="display-3 text-center text-md-start">
              Welcome to <span className="text-primary">iNoteBook</span>. <br />
              Develop anything.
            </h1>

            <p className="lead text-center text-md-start text-muted mb-6 mb-lg-8">
              iNoteBook is a note-taking application.It is intended for archiving and creating notes in which title,description and tag can be embedded.
            </p>

            <div className="text-center text-md-start">
              <div className="container" style={{ marginTop: 40 }}>
                <span>Do not have an account. Create an account with us&nbsp;&nbsp;&nbsp;</span>
                <Link to="/signup" className="btn btn-primary shadow lift me-1">
                  Sign Up<i className="fe fe-arrow-right d-none d-md-inline ms-3"></i>
                </Link>
              </div>
              <div className="container" style={{ marginTop: 40 }}>
                <span>If you are already a part of iNotebook Community.&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <Link to="/login" className="btn btn-success shadow lift me-1">
                  Login<i className="fe fe-arrow-right d-none d-md-inline ms-3"></i>
                </Link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default About;
