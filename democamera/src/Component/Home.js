import React from "react";
import "../CSS/Home.css";
import ThreeDScene from "./3dScene";

const Home = () => {
  return (
    <div className="landing-page">
      <nav className="navbar">
        <div className="logo">Logo</div>
        <ul className="nav-links">
          <li className="nav-item active">Home</li>
          <li className="nav-item">Services</li>
          <li className="nav-item">Studios</li>
          <li className="nav-item">Contact</li>
        </ul>
        <div className="menu-icon">≡</div>
      </nav>
{/* <ThreeDScene/> */}
      <div className="hero-section">
        <h1 className="hero-text">Creating More Than Just</h1>
        <h2 className="hero-subtext">Memories</h2>
        <div className="hero-buttons">
          <button className="btn book-btn">Book a Session</button>
          <button className="btn explore-btn">Explore</button>
        </div>
        {/* <ThreeDScene /> */}
        <div className="image-slider">
          <div className="slider-navigation">
            <div className="slider-dot active"></div>
            <div className="slider-dot"></div>
            <div className="slider-dot"></div>
          </div>
        </div>
      </div>

      <div className="social-media">
        <i className="social-icon twitter-icon">Twitter</i>
        <i className="social-icon facebook-icon">Facebook</i>
      </div>
    </div>
  );
};

export default Home;
