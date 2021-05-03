package main;

import domain.ControlTower;
import dto.AnnouncementSheet;
import dto.ParticipationForm;
import ui.Announcer;
import ui.Reception;

public class Main {

  private Main() {
  }

  public static void main(String[] args) {
    ParticipationForm participationForm = Reception.takeParticipationForm();
    ControlTower controlTower = new ControlTower(participationForm);
    AnnouncementSheet announcementSheet = new AnnouncementSheet(controlTower.raceStart());
    Announcer.announcement(announcementSheet);
  }
}
