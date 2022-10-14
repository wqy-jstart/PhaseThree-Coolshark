package cn.tedu.boot10.pojo.vo;

import cn.tedu.boot10.pojo.entity.Player;

import java.util.List;

/**
 * 该类用于封装查询有关团队的所有信息
 */
public class TeamVO {
    private Integer id;
    private String name;
    private String loc;
    private List<Player> playerList;

    @Override
    public String toString() {
        return "TeamVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", loc='" + loc + '\'' +
                ", playerList=" + playerList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
