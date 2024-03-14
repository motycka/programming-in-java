package com.harbourspace.tracker.activity.jpa;

import com.harbourspace.tracker.activity.ActivityJpaRepository;
import com.harbourspace.tracker.authorization.AuthorizationService;
import com.harbourspace.tracker.error.AuthorizationException;
import com.harbourspace.tracker.activity.ActivityFixtures;
import com.harbourspace.tracker.activity.ActivityService;
import com.harbourspace.tracker.activity.ActivityEntity;
import com.harbourspace.tracker.activity.ActivityJpaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;

import static com.harbourspace.tracker.activity.ActivityJpaService.fromActivity;
import static org.mockito.ArgumentMatchers.any;

public class ActivityJpaServiceTest {

    private final ActivityJpaRepository activityRepository = Mockito.mock(ActivityJpaRepository.class);
    private final AuthorizationService authorizationService = Mockito.mock(AuthorizationService.class);

    private final ActivityService activityService = new ActivityJpaService(activityRepository, authorizationService);

    @BeforeEach
    public void mock() {
        Mockito.when(authorizationService.isSystem()).thenReturn(true);
    }

    @Test
    @DisplayName("should return all activity")
    public void testGetUsers() {
        Mockito.when(activityRepository.findAll()).thenReturn(ActivityFixtures.activities.stream().map(ActivityJpaService::fromActivity).toList());

        Assertions.assertEquals(ActivityFixtures.activities, activityService.getActivity());

        Mockito.verify(activityRepository).findAll();
    }

    @Test
    @DisplayName("should user by id")
    public void testGetUser() {
        Mockito.when(activityRepository.findById(1L)).thenReturn(Optional.of(fromActivity(ActivityFixtures.activity1)));

        Assertions.assertEquals(ActivityFixtures.activity1, activityService.getActivityById(1L));

        Mockito.verify(activityRepository).findById(1L);
    }

    @Test
    @DisplayName("should create user")
    public void testCreateUser() {
        var entity = fromActivity(ActivityFixtures.newActivity);

        Mockito.when(activityRepository.save(any())).thenReturn(entity);
        Mockito.when(activityRepository.getReferenceById(any())).thenReturn(entity);

        Assertions.assertEquals(ActivityFixtures.newActivity, activityService.createActivity(ActivityFixtures.newActivity));

        Mockito.verify(activityRepository).save(any(ActivityEntity.class));
    }

    @Test
    @DisplayName("should update user")
    public void testUpdateUser() {
        var entity = fromActivity(ActivityFixtures.activity7Updated);

        Mockito.when(activityRepository.save(any())).thenReturn(entity);
        Mockito.when(activityRepository.getReferenceById(any())).thenReturn(entity);

        Assertions.assertEquals(ActivityFixtures.activity7Updated, activityService.updateActivity(ActivityFixtures.activity7Updated.getId(),ActivityFixtures.activity7Updated));

        Mockito.verify(activityRepository).save(any(ActivityEntity.class));
    }

    @Test
    @DisplayName("should delete user")
    public void testDeleteUser() {
        var entity = fromActivity(ActivityFixtures.activity7Updated);
        Mockito.when(activityRepository.getReferenceById(entity.getId())).thenReturn(entity);

        activityService.deleteActivity(entity.getId());

        Mockito.verify(activityRepository).delete(entity);
    }

    @Test
    @DisplayName("get users should throw exception when not admin")
    public void testGetUsersNotAdmin() {
        Mockito.when(authorizationService.isSystem()).thenReturn(false);

        Assertions.assertThrows(AuthorizationException.class, activityService::getActivity);

        Mockito.verifyNoInteractions(activityRepository);
    }


    @Test
    @DisplayName("update user should throw exception when not admin")
    public void testUpdateUserNotAdmin() {
        Mockito.when(authorizationService.isSystem()).thenReturn(false);

        Assertions.assertThrows(AuthorizationException.class, () -> activityService.updateActivity(ActivityFixtures.activity7Updated.getId(),ActivityFixtures.activity7Updated));

        Mockito.verifyNoInteractions(activityRepository);
    }

    @Test
    @DisplayName("delete user should throw exception when not admin")
    public void testDeleteUserNotAdmin() {
        Mockito.when(authorizationService.isSystem()).thenReturn(false);

        Assertions.assertThrows(AuthorizationException.class, () -> activityService.deleteActivity(3L));

        Mockito.verifyNoInteractions(activityRepository);
    }
}
