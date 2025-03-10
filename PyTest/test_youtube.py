import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

def test_youtube_chrome():
    print("Starting YouTube test on Chrome...")
    
    driver = webdriver.Chrome()
    driver.get("https://www.youtube.com")
    wait = WebDriverWait(driver, 10)
    
    time.sleep(2)
    
    # Search for a video
    search_box = wait.until(EC.presence_of_element_located((By.NAME, "search_query")))
    search_box.send_keys("Selenium Python tutorial")
    search_box.send_keys(Keys.RETURN)
    print("Test1: Search executed successfully.")
    
    time.sleep(2)
    
    # Click on the first video in search results
    videos = wait.until(EC.presence_of_all_elements_located((By.XPATH, "//a[@id='video-title']")))
    assert len(videos) > 0, "No videos found"
    videos[0].click()
    print("Test2: Video clicked and playing.")
    
    time.sleep(5)  # Allow video to load
    
    # Verify recommended videos are displayed
    recommendations = wait.until(EC.presence_of_all_elements_located((By.XPATH, "//ytd-compact-video-renderer")))
    assert len(recommendations) > 0, "No recommended videos found"
    print("Test3: Recommended videos are displayed.")
    
    time.sleep(2)
    
    time.sleep(2)
    
    # Pause the video
    video_player = wait.until(EC.presence_of_element_located((By.TAG_NAME, "video")))
    video_player.click()
    print("Test4: Video paused successfully.")
    
    time.sleep(2)

        # Full-screen the video
    try:
        full_screen_button = wait.until(EC.element_to_be_clickable((By.XPATH, "//button[contains(@class, 'ytp-fullscreen-button')]")))
        full_screen_button.click()
        
        time.sleep(3)  # Stay in full-screen for a moment
        
        # Exit full-screen mode
        full_screen_button.click()
        print("Test5: Succeeded full-screen mode.")
    except:
        print("Full-screen button not found or not clickable.")
    
    # Close browser
    driver.quit()
    print("Test completed successfully on Chrome.")

def test_youtube_firefox():
    print("Starting YouTube test on Firefox...")
    
    driver = webdriver.Firefox()
    driver.get("https://www.youtube.com")
    wait = WebDriverWait(driver, 10)
    
    time.sleep(2)
    
    # Search for a video
    search_box = wait.until(EC.presence_of_element_located((By.NAME, "search_query")))
    search_box.send_keys("Selenium Python tutorial")
    search_box.send_keys(Keys.RETURN)
    print("Test1: Search executed successfully.")
    
    time.sleep(2)
    
    # Click on the first video in search results
    videos = wait.until(EC.presence_of_all_elements_located((By.XPATH, "//a[@id='video-title']")))
    assert len(videos) > 0, "No videos found"
    videos[0].click()
    print("Test2: Video clicked and playing.")
    
    time.sleep(5)  # Allow video to load
    
    # Verify recommended videos are displayed
    recommendations = wait.until(EC.presence_of_all_elements_located((By.XPATH, "//ytd-compact-video-renderer")))
    assert len(recommendations) > 0, "No recommended videos found"
    print("Test3: Recommended videos are displayed.")
    
    time.sleep(2)
    
    # Pause the video
    video_player = wait.until(EC.presence_of_element_located((By.TAG_NAME, "video")))
    video_player.click()
    print("Test4: Video paused successfully.")
    
    time.sleep(2)

    # Full-screen the video
    try:
        full_screen_button = wait.until(EC.element_to_be_clickable((By.XPATH, "//button[contains(@class, 'ytp-fullscreen-button')]")))
        full_screen_button.click()
        
        time.sleep(3)  # Stay in full-screen for a moment
        
        # Exit full-screen mode
        full_screen_button.click()
        print("Test5: Succeeded full-screen mode.")
    except:
        print("Full-screen button not found or not clickable.")
    
    time.sleep(2)
    
    # Close browser
    driver.quit()
    print("Test completed successfully on Firefox.")



# import pytest
# from selenium import webdriver
# from selenium.webdriver.common.by import By
# from selenium.webdriver.common.keys import Keys
# from selenium.webdriver.support.ui import WebDriverWait
# from selenium.webdriver.support import expected_conditions as EC
# import time

# def test_youtube_chrome():
#     print("Starting YouTube test on Chrome...")
    
#     driver = webdriver.Chrome()
#     driver.get("https://www.youtube.com")
#     wait = WebDriverWait(driver, 10)
    
#     # time.sleep(2)  # Small wait for clarity
    
#     # # Accept cookies if prompted
#     # try:
#     #     cookies_button = wait.until(EC.element_to_be_clickable((By.XPATH, "//button[contains(text(), 'Accept')]")))
#     #     cookies_button.click()
#     #     print("Cookies accepted.")
#     # except:
#     #     print("No cookie prompt found.")
    
#     time.sleep(2)
    
#     # Search for a video
#     search_box = wait.until(EC.presence_of_element_located((By.NAME, "search_query")))
#     search_box.send_keys("Selenium Python tutorial")
#     search_box.send_keys(Keys.RETURN)
#     print("Test1: Search executed successfully.")
    
#     time.sleep(2)
    
#     # Click on the first video in search results
#     videos = wait.until(EC.presence_of_all_elements_located((By.XPATH, "//a[@id='video-title']")))
#     assert len(videos) > 0, "No videos found"
#     videos[0].click()
#     print("Test2: Video clicked and playing.")
    
#     time.sleep(5)  # Allow video to load
    
#     # Verify recommended videos are displayed
#     recommendations = wait.until(EC.presence_of_all_elements_located((By.XPATH, "//ytd-compact-video-renderer")))
#     assert len(recommendations) > 0, "No recommended videos found"
#     print("Test3: Recommended videos are displayed.")
    
#     time.sleep(2)
    
#     # Full-screen the video
#     try:
#         full_screen_button = wait.until(EC.element_to_be_clickable((By.XPATH, "//button[contains(@class, 'ytp-fullscreen-button')]")))
#         full_screen_button.click()
#         #print("Test4: Video set to full-screen mode.")
        
#         time.sleep(3)  # Stay in full-screen for a moment
        
#         # Exit full-screen mode
#         full_screen_button.click()
#         print("Test4: Exited full-screen mode.")
#     except:
#         print("Full-screen button not found or not clickable.")
    
#     time.sleep(2)
    
#     # Pause the video
#     video_player = wait.until(EC.presence_of_element_located((By.TAG_NAME, "video")))
#     video_player.click()
#     print("Test5: Video paused successfully.")
    
#     time.sleep(2)
    
#     # Close browser
#     driver.quit()
#     print("Test completed successfully on Chrome.")
