package com.harbourspace.tracker.activity.jpa;


import com.harbourspace.tracker.activity.ActivityEntity;
import com.harbourspace.tracker.activity.ActivityFixtures;
import com.harbourspace.tracker.activity.ActivityJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import static com.harbourspace.tracker.activity.ActivityJpaService.fromActivity;


@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ActivityJpaRepositoryTest {

    @Autowired
    private ActivityJpaRepository activityRepository;

    @Test
    @DisplayName("should select all activity")
    public void testSelectAll() {
        var activity = activityRepository.findAll();

        for (int i = 0; i < ActivityFixtures.activities.size(); i++) {
            var expected = ActivityFixtures.activities.get(i);
            var actual = activity.get(i);
            Assertions.assertEquals(expected.id(), actual.getId());
            Assertions.assertEquals(expected.userId(), actual.getUserId());
            Assertions.assertEquals(expected.name(), actual.getName());
            Assertions.assertEquals(expected.kcalPerMinute(), actual.getKcalPerMinute());
        }
    }

    @Test
    @DisplayName("should select activity by id")
    public void testSelectActivityById() {
        var expected = ActivityFixtures.activity1;
        var actual = activityRepository.findById(1L).orElseThrow();
        Assertions.assertEquals(expected.id(), actual.getId());
        Assertions.assertEquals(expected.userId(), actual.getUserId());
        Assertions.assertEquals(expected.name(), actual.getName());
        Assertions.assertEquals(expected.kcalPerMinute(), actual.getKcalPerMinute());
    }

    @Test
    @DisplayName("should select activity by name")
    public void testSelectActivityByName() {
        var expected = ActivityFixtures.activity1;
        var actual = activityRepository.findByName(expected.name()).orElseThrow();
        Assertions.assertEquals(expected.id(), actual.getId());
        Assertions.assertEquals(expected.userId(), actual.getUserId());
        Assertions.assertEquals(expected.name(), actual.getName());
        Assertions.assertEquals(expected.kcalPerMinute(), actual.getKcalPerMinute());
    }

    @Test
    @DisplayName("should insert activity")
    public void testInsertActivity() {
        Assertions.assertInstanceOf(ActivityEntity.class, activityRepository.save(fromActivity(ActivityFixtures.newActivity)));
    }

    @Test
    @DisplayName("should update activity")
    public void testUpdateActivity() {

        var activity = activityRepository.save(fromActivity(ActivityFixtures.newActivity));

        activity.setName(activity.getName() + " UPDATED");
        activity.setKcalPerMinute(activity.getKcalPerMinute());

        var updatedActivity = activityRepository.save(activity);

        Assertions.assertEquals(activity, updatedActivity);
    }

    @Test
    @DisplayName("should delete activity")
    public void testDeleteActivity() {
        var activity = activityRepository.save(fromActivity(ActivityFixtures.newActivity));
        activityRepository.delete(activity);
        Assertions.assertFalse(activityRepository.findById(activity.getId()).isPresent());

    }
}
