package com.harbourspace.tracker.activity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harbourspace.tracker.config.SecurityConfiguration;
import com.harbourspace.tracker.authorization.AuthorizationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ActivityController.class)
@Import(SecurityConfiguration.class)
public class ActivityControllerTest {
    @MockBean
    private ActivityService activityService;

    @MockBean
    private AuthorizationService authorizationService;

    @Autowired
    private MockMvc mockMvc;

    private final String path = "/api/activity";

    @BeforeEach
    void setUp() {
        Mockito.when(activityService.getActivity()).thenReturn(ActivityFixtures.activities);
        Mockito.when(activityService.getActivityById(1L)).thenReturn(ActivityFixtures.activity0);
        Mockito.when(activityService.getActivityByUserId(0L)).thenReturn(ActivityFixtures.activities);
        Mockito.when(activityService.getActivityByName("Running")).thenReturn(ActivityFixtures.activity1);
        Mockito.when(activityService.createActivity(ActivityFixtures.newActivity)).thenReturn(ActivityFixtures.activity7);
        Mockito.when(activityService.updateActivity(ActivityFixtures.activity7Updated.getId(),ActivityFixtures.activity7Updated)).thenReturn(ActivityFixtures.activity7Updated);
    }

    @Test
    @DisplayName("GET /api/activity")
    void testGetActivity() throws Exception {
        var expected = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"userId\": 0,\n" +
                "        \"name\": \"Walking\",\n" +
                "        \"type\": \"SYSTEM\",\n" +
                "        \"kcalPerMinute\": 5.0\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"userId\": 0,\n" +
                "        \"name\": \"Running\",\n" +
                "        \"type\": \"SYSTEM\",\n" +
                "        \"kcalPerMinute\": 10.0\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"userId\": 0,\n" +
                "        \"name\": \"Cycling\",\n" +
                "        \"type\": \"SYSTEM\",\n" +
                "        \"kcalPerMinute\": 8.0\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 4,\n" +
                "        \"userId\": 0,\n" +
                "        \"name\": \"Swimming\",\n" +
                "        \"type\": \"SYSTEM\",\n" +
                "        \"kcalPerMinute\": 7.0\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 5,\n" +
                "        \"userId\": 0,\n" +
                "        \"name\": \"Weight Training\",\n" +
                "        \"type\": \"SYSTEM\",\n" +
                "        \"kcalPerMinute\": 3.0\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 6,\n" +
                "        \"userId\": 1,\n" +
                "        \"name\": \"Eating\",\n" +
                "        \"type\": \"USER\",\n" +
                "        \"kcalPerMinute\": 5.0\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 7,\n" +
                "        \"userId\": 2,\n" +
                "        \"name\": \"Crying\",\n" +
                "        \"type\": \"USER\",\n" +
                "        \"kcalPerMinute\": 10.0\n" +
                "    }\n" +
                "]";
        mockMvc.perform(get(path).header("Authorization", "Basic 0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expected));
    }

    @Test
    @DisplayName("GET /api/activity/1")
    void testGetActivityById() throws Exception {
        mockMvc.perform(get(path + "/1").header("Authorization", "Basic 0"))
                .andDo(print())
                .andExpect(status().isOk()) // Ensure the response is OK
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.userId").value(0)) // Ensure this matches the actual JSON key
                .andExpect(jsonPath("$.name").value("Walking"))
                .andExpect(jsonPath("$.type").value("SYSTEM"))
                .andExpect(jsonPath("$.kcalPerMinute").value(5.0)); // Ensure camelCase is used if that's what the response uses
    }


    @Test
    @DisplayName("POST /api/activity")
    void testCreateUser() throws Exception {
        var expected = "{\n" +
                "    \"id\": 9,\n" +
                "    \"userId\": 1,\n" +
                "    \"name\": \"Jumping Jack\",\n" +
                "    \"type\": \"USER\",\n" +
                "    \"kcalPerMinute\": 50.0\n" +
                "}";
        var post = MockMvcRequestBuilders.post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(ActivityFixtures.newActivity))
                .header("Authorization", "Basic 0");

        mockMvc.perform(post)
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(expected));
    }

    @Test
    @DisplayName("PUT /api/activity/activity5Updated")
    void testUpdateUser() throws Exception {
        var expected = "{\n" +
                "    \"id\": 3,\n" +
                "    \"userId\": 0,\n" +
                "    \"name\": \"Working\",\n" +
                "    \"type\": \"SYSTEM\",\n" +
                "    \"kcalPerMinute\": 10.0\n" +
                "}";

        var put = MockMvcRequestBuilders.put(path + "/3")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(ActivityFixtures.activity7Updated))
                .header("Authorization", "Basic 0");

        mockMvc.perform(put)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expected));
    }


    @Test
    @DisplayName("DELETE /api/activity/5")
    void testDeleteUser() throws Exception {
        mockMvc.perform(delete(path + "/5").header("Authorization", "Basic 0"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
