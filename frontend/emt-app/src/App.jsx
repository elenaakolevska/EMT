import React from 'react';
import CountriesPage from "./ui/pages/CountriesPage/CountriesPage.jsx";
import {BrowserRouter, Routes, Route} from "react-router-dom";
import Layout from "./ui/components/layout/Layout/Layout.jsx";
import HomePage from "./ui/pages/HomePage/HomePage.jsx";
import CountriesDetails from "./ui/components/countries/CountryDetails/CountryDetails.jsx";

const App = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Layout/>}>
                    <Route index element={<HomePage/>}/>
                    <Route path="countries" element={<CountriesPage/>}/>
                    <Route path="countries/:id" element={<CountriesDetails/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
};

export default App;