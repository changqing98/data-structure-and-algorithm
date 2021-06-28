import os

if __name__ == '__main__':
  path = os.path.dirname(__file__)
  dirs = ["basic", "common", "leetcode.jian_zhi_offer", "leetcode", "nowcoder"]
  for dir in dirs:
    sec_dir_a_path = path + "/src/" + dir
    for file in os.listdir(sec_dir_a_path):
      target = sec_dir_a_path + "/" + file
      if os.path.isdir(target):
        updated_file_name = file.replace("-", "_").replace(".", "_").lower()
        if updated_file_name[0].isdigit():
          updated_file_name = "p" + updated_file_name
          os.rename(target, sec_dir_a_path + "/" + updated_file_name)
