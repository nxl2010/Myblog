import { ref, onMounted } from 'vue';
import axios from 'axios';

export const recentPosts = ref([
  {
    title: 'Tiêu đề bài viết 1',
    date: '20/10/2001',
  },
  {
    title: 'Tiêu đề bài viết 2',
    date: '20/10/2001',
  },
  // Thêm các bài viết khác vào đây
]);

export const quotes = ref([]);
export const tagNames = ref([]);

export const fetchQuotes = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/v3/quotes/random');
    quotes.value = response.data;
  } catch (error) {
    console.error('Error fetching quotes:', error);
  }
};

export const fetchTagName = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/v3/tagname');
    tagNames.value = response.data;
  } catch (error) {
    console.error('Error fetching TagName:', error);
  }
};

export const initializeData = () => {
  onMounted(() => {
    fetchQuotes();
    fetchTagName();
  });
};
