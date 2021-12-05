package com.blendpach.busmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import dataModels.busagent;

@Repository
public class busAgentStat<JdbcTemplate> {

    @GetMapping("/retrieveall")
    // public List<busagent> loadAll() {

    // //String sql = "select * from busagent";

    // // return jdbcTemplate.query("select * from busagent");

    // // return tobusagent(result);

    // }

    private busagent tobusagent(ResultSet resultSet) throws SQLException {

        busagent busagent = new busagent();
        busagent.setBusaeg_averagetimebetstops(resultSet.getString("busaeg_averagetimebetstops"));
        busagent.setBusage_averagespeed(resultSet.getString("busage_averagespeed"));
        busagent.setBusage_id(resultSet.getInt("busage_id"));
        busagent.setBusage_nostops(resultSet.getString("busage_nostops"));
        busagent.setBusage_routeid(resultSet.getString("busage_routeid"));
        busagent.setBusage_triptime(resultSet.getString("busage_triptime"));

        return busagent;
    }

}